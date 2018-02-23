package com.sefah.atna.auditmessages.validator.base;

import java.util.List;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.exceptions.ValidatorErrorCode;
import com.sefah.atna.exceptions.ValidatorException;

/**
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public interface ActiveParticipantValidatorMethod {

  default void checkActiveParticipantIs1(final List<ActiveParticipant> activeParticipant)
      throws ValidatorException {
    if (activeParticipant != null && activeParticipant.size() == 1) {
      return;
    }
    throw new ValidatorException(ValidatorErrorCode.ATNA_ACTIVE_PARTICANT_1);
  }

  default void checkActiveParticipantNotEmpty(final List<ActiveParticipant> activeParticipant)
      throws ValidatorException {
    if (activeParticipant != null && !activeParticipant.isEmpty()) {
      return;
    }
    throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
  }

  default void checkActiveParticipant1Or2(final List<ActiveParticipant> activeParticipant)
      throws ValidatorException {
    if (activeParticipant != null && checkListValueIsBetween(activeParticipant, 1, 2)) {
      return;
    }

    throw new ValidatorException(ValidatorErrorCode.ATNA_ACTIVE_PARTICANT_1OR2);
  }

  static boolean checkListValueIsBetween(final List<?> list, final int minValue,
      final int maxValue) {
    return !list.isEmpty() && list.size() >= minValue && list.size() <= maxValue;
  }

}
