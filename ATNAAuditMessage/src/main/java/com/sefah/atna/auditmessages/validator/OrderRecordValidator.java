package com.sefah.atna.auditmessages.validator;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.auditmessages.validator.base.ActiveParticipantValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.EventInformationValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.ParticipantObjectIdentificationValidatorMethod;
import com.sefah.atna.auditmessages.validator.base.Validator;
import com.sefah.atna.exceptions.ValidatorException;

/**
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class OrderRecordValidator implements ActiveParticipantValidatorMethod,
    EventInformationValidatorMethod, ParticipantObjectIdentificationValidatorMethod, Validator {

  @Override
  public boolean validate(final AuditMessage auditMessage) throws ValidatorException {
    checkAuditMessage(auditMessage);

    checkEventInformationExists(auditMessage.getEvent());
    checkEventInformationDetails(auditMessage.getEvent());

    checkParticipantObjectIdentificationIs1(auditMessage.getParticipantObject());

    return true;
  }

}
