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
public enum ParticipantObjectIDTypeCode {
  /** "12", URI */
  URI("12", null, "URI"),
  /** "2", Patient ID */
  PATIENT_ID("2", null, "Patient ID");

  @XmlAttribute(name = "ParticipantObjectIDTypeCode")
  private EV code;

  private ParticipantObjectIDTypeCode(final String code, final String name,
      final String originalValue) {
    this.code = new EV(code, name, originalValue);
  }

  public EV getCode() {
    return code;
  }
}
