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
public enum ParticipantObjectTypeCode {
  /** "1", PERSON */
  PERSON(new EV(1)),
  /** "2", SYSTEM */
  SYSTEM(new EV(2)),
  /** "2", SYSTEM_OBJECT */
  SYSTEM_OBJECT(new EV(2)),
  /** "3", ORGANIZATION */
  ORGANIZATION(new EV(3)),
  /** "4", OTHER */
  OTHER(new EV(4));

  @XmlAttribute(name = "ParticipantObjectTypeCode")
  private EV code;

  private ParticipantObjectTypeCode(final EV code) {
    this.code = code;
  }

  public Integer getActionCode() {
    return code.getActionCodeAsInteger();
  }

  public EV getCode() {
    return code;
  }
}
