package com.sefah.atna.codes;

import javax.xml.bind.annotation.XmlAttribute;

import com.sefah.atna.event.EV;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public enum EventOutcomeCodes {
  /** "0", Success */
  SUCCESS(new EV("0")),
  /** "4", Minor Failure */
  MINOR_FAILURE(new EV("4")),
  /** "8", Serious Failure */
  SERIOUS_FAILURE(new EV("8")),
  /** "12", Major Failure */
  MAJOR_FAILURE(new EV("12"));

  @XmlAttribute(name = "EventOutcomeCodes")
  private EV code;

  private EventOutcomeCodes(final EV code) {
    this.code = code;
  }

  public EV getCode() {
    return code;
  }

  public Integer getActionCode() {
    return Integer.parseInt(code.getCode());
  }

  public static EventOutcomeCodes getCodeForInt(final int value) {
    switch (value) {
    case 4:
      return MINOR_FAILURE;
    case 8:
      return SERIOUS_FAILURE;
    case 12:
      return MAJOR_FAILURE;
    default:
      return SUCCESS;
    }
  }
}
