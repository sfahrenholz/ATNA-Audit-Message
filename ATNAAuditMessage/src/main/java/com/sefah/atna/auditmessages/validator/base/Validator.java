package com.sefah.atna.auditmessages.validator.base;

import java.util.List;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.codes.ParticipantObjectIDTypeCode;
import com.sefah.atna.codes.ParticipantObjectTypeCode;
import com.sefah.atna.codes.ParticipantObjectTypeCodeRole;
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
public interface Validator {

  public abstract boolean validate(final AuditMessage auditMessage) throws ValidatorException;

  default void checkAuditMessage(final AuditMessage auditMessage) throws ValidatorException {
    if (auditMessage == null) {
      throw new ValidatorException(ValidatorErrorCode.ATNA_MESSAGE_NULL);
    }
  }

  /**
   * Check if ActiveParticipant has the <code>UserID<code> and <code>UserIsRequestor</code> value
   *
   * @param activeParticipant
   * @return
   */
  default boolean checkActiveParticipantUserIDUserIsRequestor(
      final ActiveParticipant activeParticipant) {
    return activeParticipant.getUserID() != null && activeParticipant.getUserIsRequestor() != null;
  }

  /**
   * Check if ActiveParticipant (ParticipantObjectTypeCode.PERSON) has the
   * ParticipantObjectTypeCodeRole
   * <code>PATIENT<code> and ParticipantObjectIDTypeCode <code>PATIENT_ID</code> and
   * ParticipantObjectID is not <code>null</code>
   *
   * @param activeParticipant
   * @return
   */
  default boolean checkRequiredPatientField(
      final ParticipantObjectIdentification participantObject) {
    return participantObject.getParticipantObjectTypeCodeRole()
        .equals(ParticipantObjectTypeCodeRole.PATIENT.getActionCode())
        && participantObject.getParticipantObjectIDTypeCode()
            .equals(ParticipantObjectIDTypeCode.PATIENT_ID.getCode())
        && participantObject.getParticipantObjectID() != null;
  }

  /**
   * Check if ParticipantObjectIdentification for the type <code>PATIENT-ID</code> is the
   * ParticipantObjectTypeCode
   * <code>PERSON<code> and ParticipantObjectTypeCodeRole <code>PATIENT</code> value
   *
   * @param activeParticipant
   * @return
   */
  default boolean checkParticipantObjectIdentificationForPatientIDIfPersonAndPatient(
      final ParticipantObjectIdentification participantObject) {
    return participantObject.getParticipantObjectTypeCode()
        .equals(ParticipantObjectTypeCode.PERSON.getActionCode())
        && participantObject.getParticipantObjectTypeCodeRole()
            .equals(ParticipantObjectTypeCodeRole.PATIENT.getActionCode());
  }

  /**
   * Check if ParticipantObjectIdentification for the type <code>SYSTEM</code> is the
   * ParticipantObjectTypeCode <code>REPORT<code> and <code>ParticipantObjectID</code> and
   * <code>SopClass</code> set value
   *
   * @param activeParticipant
   * @return
   */
  default boolean checkParticipantObjectIdentificationForSystemIfReportObjectIDAndSOPClass(
      final ParticipantObjectIdentification participantObject) {
    return participantObject.getParticipantObjectTypeCode()
        .equals(ParticipantObjectTypeCode.SYSTEM.getActionCode())
        && participantObject.getParticipantObjectTypeCodeRole()
            .equals(ParticipantObjectTypeCodeRole.REPORT.getActionCode())
        && checkParticipantObjectIdentificationReportObjectIDAndSOPClassNotNull(participantObject);
  }

  default boolean checkParticipantObjectIdentificationReportObjectIDAndSOPClassNotNull(
      final ParticipantObjectIdentification participantObject) {
    return participantObject.getParticipantObjectID() != null
        && participantObject.getSopClass() != null;
  }

  /**
   * Check if ActiveParticipant is the <code>UserIsRequestor</code> only on one ActiveParticipant
   * <code>true</code>
   *
   * @param activeParticipant
   * @return
   */
  default boolean checkUserRequesterOnlyOneTrue(final CountOfObjects check,
      final ActiveParticipant activeParticipant) {
    if (activeParticipant.getUserIsRequestor()) {
      if (!check.isHasUserRequestor()) {
        check.hasUserRequestor();
      } else {
        return false;
      }
    }
    return true;
  }

  default void handleDCM110180PERSONParticipantObjectIdentification(final CountOfObjects check,
      final ParticipantObjectIdentification participantObject) throws ValidatorException {
    // Check 1 to N Study
    if (participantObject.getParticipantObjectIDTypeCode().equals(EventID.DCM_110180)) {
      if (!checkParticipantObjectIdentificationForSystemIfReportObjectIDAndSOPClass(
          participantObject)) {
        throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
      }
      check.increasedcm110180();
    } else {
      // Check 1 Patient
      if (participantObject.getParticipantObjectTypeCode()
          .equals(ParticipantObjectTypeCode.PERSON.getActionCode())) {
        if (!checkRequiredPatientField(participantObject)) {
          throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
        }
        check.increasedPatient();
      } else {
        throw new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);
      }
    }

  }

  default boolean handleDCM110153ActiveParticipant(final CountOfObjects check,
      final ActiveParticipant activeParticipant) {
    if (activeParticipant.getRoleIDCode().equals(EventID.DCM_110153)) {
      if (!checkActiveParticipantUserIDUserIsRequestor(activeParticipant)) {
        return false;
      }
      check.increasedcm110153();
    }
    return true;
  }

  default boolean handleDCM110152ActiveParticipant(final CountOfObjects check,
      final ActiveParticipant activeParticipant) {
    if (activeParticipant.getRoleIDCode().equals(EventID.DCM_110152)) {
      if (!checkActiveParticipantUserIDUserIsRequestor(activeParticipant)) {
        return false;
      }
      check.increasedcm110152();
    }
    return true;
  }

  //

  static boolean checkListValueIsBetween(final List<?> list, final int minValue,
      final int maxValue) {
    return !list.isEmpty() && list.size() >= minValue && list.size() <= maxValue;
  }
}
