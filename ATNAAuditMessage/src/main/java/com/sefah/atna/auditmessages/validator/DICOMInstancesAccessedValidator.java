package com.sefah.atna.auditmessages.validator;

import java.util.List;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.auditmessages.validator.base.ActiveParticipantValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.CountOfObjects;
import com.sefah.atna.auditmessages.validator.base.EventInformationValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.ParticipantObjectIdentificationValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.Validator;
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
public class DICOMInstancesAccessedValidator implements ActiveParticipantValidatorMethod,
    EventInformationValidatorMethod, ParticipantObjectIdentificationValidatorMethod, Validator {

  @Override
  public boolean validate(final AuditMessage auditMessage) throws ValidatorException {
    checkAuditMessage(auditMessage);
    checkEventInformationExists(auditMessage.getEvent());
    checkEventInformationDetails(auditMessage.getEvent());
    checkActiveParticipant(auditMessage.getActiveParticipant());
    checkParticipantObjectIdentificationGreater1(auditMessage.getParticipantObject());
    return checkParticipantObjectIdentification(auditMessage.getParticipantObject());
  }

  private boolean checkParticipantObjectIdentification(
      final List<ParticipantObjectIdentification> participantObject) throws ValidatorException {
    final CountOfObjects check = new CountOfObjects();
    for (final ParticipantObjectIdentification participantObject2 : participantObject) {
      handleDCM110180PERSONParticipantObjectIdentification(check, participantObject2);
    }

    return check.getDcm110180() != 0 && check.getPatient() == 1;
  }

  private void checkActiveParticipant(final List<ActiveParticipant> activeParticipant)
      throws ValidatorException {
    final CountOfObjects check = new CountOfObjects();
    for (final ActiveParticipant activeParticipant2 : activeParticipant) {
      if (!checkUserRequesterOnlyOneTrue(check, activeParticipant2)) {
        throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
      }
      if (!checkActiveParticipantUserIDUserIsRequestor(activeParticipant2)) {
        throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
      }
    }

  }
}
