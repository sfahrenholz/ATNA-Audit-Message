package com.sefah.atna.auditmessages.validator.base;

import java.util.List;

import com.sefah.atna.exceptions.ValidatorErrorCode;
import com.sefah.atna.exceptions.ValidatorException;
import com.sefah.atna.participantobjectidentification.ParticipantObjectIdentification;

/**
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public interface ParticipantObjectIdentificationValidatorMethod {

  default boolean checkParticipantObjectIdentificationNotEmpty(
      final List<ParticipantObjectIdentification> participantObject) {
    return participantObject != null && !participantObject.isEmpty();
  }

  default void checkParticipantObjectIdentificationIs1(
      final List<ParticipantObjectIdentification> participantObject) throws ValidatorException {
    if (participantObject != null && participantObject.size() == 1) {
      return;
    }

    throw new ValidatorException(ValidatorErrorCode.ATNA_PARTICIPANT_OBJECT_1);
  }

  default void checkParticipantObjectIdentificationGreater1(
      final List<ParticipantObjectIdentification> participantObject) throws ValidatorException {
    if (participantObject != null && participantObject.size() >= 2) {
      return;
    }

    throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
  }
}
