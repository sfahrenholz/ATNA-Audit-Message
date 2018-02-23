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
public enum ParticipantObjectTypeCodeRole {
  /** "1", PATIENT */
  PATIENT(new EV(1)),
  /** "3", REPORT */
  REPORT(new EV(3)),
  /** "5", MASTER_FILE */
  MASTER_FILE(new EV(5)),
  /** "13", SECURITY_RESOURCE */
  SECURITY_RESOURCE(new EV(13)),
  /** "20", JOB */
  JOB(new EV(20)),
  /** "24", QUERY */
  QUERY(new EV(24));

  @XmlAttribute(name = "ParticipantObjectTypeCodeRole")
  private EV code;

  private ParticipantObjectTypeCodeRole(final EV code) {
    this.code = code;
  }

  public Integer getActionCode() {
    return code.getActionCodeAsInteger();
  }

  public EV getCode() {
    return code;
  }
}
