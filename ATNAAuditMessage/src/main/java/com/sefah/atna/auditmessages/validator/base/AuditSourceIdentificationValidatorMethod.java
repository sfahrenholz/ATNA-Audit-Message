package com.sefah.atna.auditmessages.validator.base;

import java.util.List;

import com.sefah.atna.auditsourceidentification.AuditSourceIdentification;
import com.sefah.atna.exceptions.ValidatorErrorCode;
import com.sefah.atna.exceptions.ValidatorException;

/**
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public interface AuditSourceIdentificationValidatorMethod {

  default void checkAuditSourceIdentificationIs1(
      final List<AuditSourceIdentification> sourceIdentification) throws ValidatorException {
    if (sourceIdentification != null && sourceIdentification.size() == 1) {
      return;
    }
    throw new ValidatorException(ValidatorErrorCode.ATNA_AUDIT_SOURCE_1);
  }
}
