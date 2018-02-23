package com.sefah.atna.auditmessages.validator.base;

import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.eventidentification.EventIdentification;
import com.sefah.atna.exceptions.ValidatorErrorCode;
import com.sefah.atna.exceptions.ValidatorException;

/**
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public interface EventInformationValidatorMethod {

  default void checkEventInformationExists(final EventIdentification eventInfo)
      throws ValidatorException {
    if (eventInfo == null) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_MISSING_REQ_EVENTINFORMATION);
    }
  }

  default void checkEventInformationEventActionCode(final EventIdentification eventInfo)
      throws ValidatorException {
    if (eventInfo.getEventActionCode() == null) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_MISSING_REQ_EVENTACTIONCODE);
    }
  }

  default void checkEventInformationEventID(final EventIdentification eventInfo)
      throws ValidatorException {
    if (eventInfo.getEventID() == null) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_MISSING_REQ_EVENTID);
    }
  }

  default void checkEventInformationEventTypeCode(final EventIdentification eventInfo)
      throws ValidatorException {
    if (eventInfo.getEventID() == null) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_MISSING_REQ_EVENTTYPECODE);
    }
  }

  default void checkEventInformationEventOutcomeIndicator(final EventIdentification eventInfo)
      throws ValidatorException {
    if (eventInfo.getEventID() == null) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_MISSING_REQ_EVENTOUTCOMEINDICATOR);
    }
  }

  default void checkEventInformationDetails(final EventIdentification event)
      throws ValidatorException {
    checkEventInformationEventActionCode(event);
    checkEventInformationEventOutcomeIndicator(event);
  }

  default void checkEventInformationAllFieldsAreMandatory(final EventIdentification eventInfo)
      throws ValidatorException {

    checkEventInformationExists(eventInfo);
    checkEventInformationEventActionCode(eventInfo);
    checkEventInformationEventID(eventInfo);
    checkEventInformationEventTypeCode(eventInfo);
    checkEventInformationEventOutcomeIndicator(eventInfo);
  }

  default void checkEventInformationEventActionCodeCreateReadUpdate(
      final EventIdentification eventInfo) throws ValidatorException {
    if (!EventActionCodes.CREATE.getCode().getCode()
        .equalsIgnoreCase(eventInfo.getEventActionCode())
        && !EventActionCodes.READ.getCode().getCode()
            .equalsIgnoreCase(eventInfo.getEventActionCode())
        && !EventActionCodes.UPDATE.getCode().getCode()
            .equalsIgnoreCase(eventInfo.getEventActionCode())) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_EVENTINFO_ACTION_CODE,
          eventInfo.getEventActionCode());
    }
  }

  default void checkEventInformationEventActionCodeCreate(final EventIdentification eventInfo)
      throws ValidatorException {
    if (!EventActionCodes.CREATE.getCode().getCode()
        .equalsIgnoreCase(eventInfo.getEventActionCode())) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_EVENTINFO_ACTION_CODE_CREATE);
    }
  }

  default void checkEventInformationEventActionCodeRead(final EventIdentification eventInfo)
      throws ValidatorException {
    if (!EventActionCodes.READ.getCode().getCode()
        .equalsIgnoreCase(eventInfo.getEventActionCode())) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_EVENTINFO_ACTION_CODE_READ);
    }
  }

  default void checkEventInformationEventActionCodeUpdate(final EventIdentification eventInfo)
      throws ValidatorException {
    if (!EventActionCodes.UPDATE.getCode().getCode()
        .equalsIgnoreCase(eventInfo.getEventActionCode())) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_EVENTINFO_ACTION_CODE_UPDATE);
    }
  }

  default void checkEventInformationEventActionCodeDelete(final EventIdentification eventInfo)
      throws ValidatorException {
    if (!EventActionCodes.DELETE.getCode().getCode()
        .equalsIgnoreCase(eventInfo.getEventActionCode())) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_EVENTINFO_ACTION_CODE_DELETE);
    }
  }

  default void checkEventInformationEventActionCodeExecute(final EventIdentification eventInfo)
      throws ValidatorException {
    if (!EventActionCodes.EXECUTE.getCode().getCode()
        .equalsIgnoreCase(eventInfo.getEventActionCode())) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_EVENTINFO_ACTION_CODE_EXECUTE);
    }
  }
}
