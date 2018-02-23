package com.sefah.atna.auditmessages.validator;

import java.util.List;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.auditmessages.validator.base.ActiveParticipantValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.CountOfObjects;
import com.sefah.atna.auditmessages.validator.base.EventInformationValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.ParticipantObjectIdentificationValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.Validator;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.codes.ParticipantObjectIDTypeCode;
import com.sefah.atna.exceptions.ValidatorErrorCode;
import com.sefah.atna.exceptions.ValidatorException;
import com.sefah.atna.participantobjectidentification.ParticipantObjectIdentification;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class DICOMInstancesTransferredValidator implements ActiveParticipantValidatorMethod,
    EventInformationValidatorMethod, ParticipantObjectIdentificationValidatorMethod, Validator {

  @Override
  public boolean validate(final AuditMessage auditMessage) throws ValidatorException {
    checkAuditMessage(auditMessage);

    checkEventInformationExists(auditMessage.getEvent());
    checkEventInformationDetails(auditMessage.getEvent());
    checkEventInformationEventActionCodeCreateReadUpdate(auditMessage.getEvent());

    checkActiveParticipant(auditMessage.getActiveParticipant());

    checkParticipantObjectIdentificationGreater1(auditMessage.getParticipantObject());
    checkParticipantObjectIdentification(auditMessage.getParticipantObject());

    return true;
  }

  private void checkParticipantObjectIdentification(
      final List<ParticipantObjectIdentification> participantObject) throws ValidatorException {
    final CountOfObjects check = new CountOfObjects();
    for (final ParticipantObjectIdentification participantObject2 : participantObject) {
      if (participantObject2.getParticipantObjectIDTypeCode()
          .equals(ParticipantObjectIDTypeCode.PATIENT_ID.getCode())) {
        if (!checkParticipantObjectIdentificationForPatientIDIfPersonAndPatient(
            participantObject2)) {
          throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
        }
        check.increasedPatient();
      } else if (participantObject2.getParticipantObjectIDTypeCode().equals(EventID.DCM_110180)) {
        if (!checkParticipantObjectIdentificationForSystemIfReportObjectIDAndSOPClass(
            participantObject2)) {
          throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
        }
        check.increasedcm110180();
      }
    }

    if (check.getPatient() == 1 && check.getDcm110180() > 0) {
      return;
    }
    throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
  }

  private void checkActiveParticipant(final List<ActiveParticipant> activeParticipant)
      throws ValidatorException {
    final CountOfObjects check = new CountOfObjects();
    for (final ActiveParticipant activeParticipant2 : activeParticipant) {
      if (!checkUserRequesterOnlyOneTrue(check, activeParticipant2)
          || !handleDCM110153ActiveParticipant(check, activeParticipant2)
          || !handleDCM110152ActiveParticipant(check, activeParticipant2)
          || !checkActiveParticipantUserIDUserIsRequestor(activeParticipant2)) {
        throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
      }
    }

    if (check.getDcm110152() == 1 && check.getDcm110153() == 1) {
      return;
    }
    throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
  }

}
