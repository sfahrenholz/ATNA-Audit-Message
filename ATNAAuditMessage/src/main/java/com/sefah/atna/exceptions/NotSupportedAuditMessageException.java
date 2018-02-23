package com.sefah.atna.exceptions;

/**
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class NotSupportedAuditMessageException extends Exception {

  private static final long serialVersionUID = -2154863361659491838L;

  public NotSupportedAuditMessageException(final String string) {
    super(string);
  }

}
