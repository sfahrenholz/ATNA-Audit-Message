package com.sefah.atna.auditmessages.validator;

import java.util.List;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.auditmessages.validator.base.ActiveParticipantValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.EventInformationValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.ParticipantObjectIdentificationValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.Validator;
import com.sefah.atna.exceptions.ValidatorErrorCode;
import com.sefah.atna.exceptions.ValidatorException;

/**
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class NetworkEntryValidator implements ActiveParticipantValidatorMethod,
    EventInformationValidatorMethod, ParticipantObjectIdentificationValidatorMethod, Validator {

  @Override
  public boolean validate(final AuditMessage auditMessage) throws ValidatorException {
    checkAuditMessage(auditMessage);
    checkEventInformationExists(auditMessage.getEvent());
    checkEventInformationDetails(auditMessage.getEvent());
    checkActiveParticipantIs1(auditMessage.getActiveParticipant());
    checkUserIDIsRequired(auditMessage.getActiveParticipant());
    checkAllActiveParticipanUserIsRequestorFalse(auditMessage.getActiveParticipant());

    return true;
  }

  private void checkUserIDIsRequired(final List<ActiveParticipant> activeParticipant)
      throws ValidatorException {
    for (final ActiveParticipant activeParticipant2 : activeParticipant) {
      if (activeParticipant2.getUserID() == null) {
        throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
      }
    }
  }

  private void checkAllActiveParticipanUserIsRequestorFalse(
      final List<ActiveParticipant> activeParticipant) throws ValidatorException {
    for (final ActiveParticipant activeParticipant2 : activeParticipant) {
      if (activeParticipant2.getUserIsRequestor()) {
        throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
      }
    }
  }
}
