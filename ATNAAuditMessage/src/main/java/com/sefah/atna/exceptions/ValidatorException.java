package com.sefah.atna.exceptions;

import java.text.MessageFormat;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class ValidatorException extends Exception {

  private static final long serialVersionUID = 4230971179805509360L;
  private final String errorCode;
  private final String errorMsg;
  private final StackTraceElement[] stackTrace;

  public ValidatorException(final ValidatorErrorCode code) {
    errorMsg = code.getDescription();
    errorCode = code.getCode();
    stackTrace = Thread.currentThread().getStackTrace();
  }

  public ValidatorException(final ValidatorErrorCode code, final Object... string) {
    errorMsg = MessageFormat.format(code.getDescription(), string);
    errorCode = code.getCode();

    stackTrace = Thread.currentThread().getStackTrace();
  }

  public String getErrorCode() {
    return errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  @Override
  public StackTraceElement[] getStackTrace() {
    return stackTrace;
  }

  public String getError() {
    final StringBuilder sb = new StringBuilder();
    sb.append(errorMsg);

    if (stackTrace != null) {
      for (int i = 2; i < stackTrace.length; i++) {
        sb.append("\n").append("\t").append(stackTrace[i]);
      }
    } else {
      sb.append("\n").append("\t").append("<No Stacktrace available>");
    }

    return sb.toString();
  }
}
