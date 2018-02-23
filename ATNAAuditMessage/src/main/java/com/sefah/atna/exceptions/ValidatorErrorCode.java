/**
 *
 */
package com.sefah.atna.exceptions;

/**
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public enum ValidatorErrorCode {
  ATNA_DEFAULT("-1", "TODO"), ATNA_MESSAGE_NULL("00000",
      "The Audit Message is null, cannot check validator for non message."), ATNA_VALIDATOR_FACTORY(
          "00001", "For the message event {0}, there is no validator."),

  ATNA_MISSING_REQ_EVENTINFORMATION("00010",
      "Validation failed, there is no Event Information."), ATNA_MISSING_REQ_EVENTINFORMATION_DETAIL(
          "00011",
          "Validation failed, the Event Information has no required details."), ATNA_MISSING_REQ_EVENTACTIONCODE(
              "00012",
              "Validation failed, the required value for EventActionCode is missing."), ATNA_MISSING_REQ_EVENTID(
                  "00013",
                  "Validation failed, the required value for EventID is missing."), ATNA_MISSING_REQ_EVENTTYPECODE(
                      "00014",
                      "Validation failed, the required value for EventTypeCode is missing."), ATNA_MISSING_REQ_EVENTOUTCOMEINDICATOR(
                          "00015",
                          "Validation failed, the required value for EventOutcomeIndicator is missing."), ATNA_EVENTINFO_ACTION_CODE_CREATE(
                              "00016c",
                              "Validation failed, for the EventActionCode 'CREATE' is needed."), ATNA_EVENTINFO_ACTION_CODE_READ(
                                  "00016r",
                                  "Validation failed, for the EventActionCode 'READ' is needed."), ATNA_EVENTINFO_ACTION_CODE_UPDATE(
                                      "00016u",
                                      "Validation failed, for the EventActionCode 'UPDATE' is needed."), ATNA_EVENTINFO_ACTION_CODE_DELETE(
                                          "00016d",
                                          "Validation failed, for the EventActionCode 'DELETE' is needed."), ATNA_EVENTINFO_ACTION_CODE_EXECUTE(
                                              "00016e",
                                              "Validation failed, for the EventActionCode 'EXECUTE' is needed."), ATNA_EVENTINFO_ACTION_CODE(
                                                  "00017",
                                                  "Validation failed, for the EventActionCode the value is not valid: {0}."),

  ATNA_ACTIVE_PARTICANT_1OR2("00020",
      "Validation failed, for the current message are 1 oder 2 Active Participant required."), ATNA_ACTIVE_PARTICANT_1(
          "00021",
          "Validation failed, for the current message are 1 Active Participant required."), ATNA_PARTICIPANT_OBJECT_1(
              "00030",
              "Validation failed, for the current message are 1 Participant Object Identification required."), ATNA_AUDIT_SOURCE_1(
                  "00040",
                  "Validation failed, for the current message are 1 Audit Source Identification required.");

  private final String code;
  private final String description;

  private ValidatorErrorCode(final String code, final String description) {
    this.code = "ATNA_" + code;
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public String getCode() {
    return code;
  }

  @Override
  public String toString() {
    return code + ": " + description;
  }
}
