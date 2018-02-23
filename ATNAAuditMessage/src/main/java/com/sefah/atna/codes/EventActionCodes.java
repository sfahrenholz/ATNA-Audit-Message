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
public enum EventActionCodes {
  CREATE(new EV("C")), READ(new EV("R")), UPDATE(new EV("U")), EXECUTE(new EV("E")), DELETE(
      new EV("D"));

  @XmlAttribute(name = "EventTypeCode")
  private EV code;

  private EventActionCodes(final EV code) {
    this.code = code;
  }

  public EV getCode() {
    return code;
  }

  public String getActionCode() {
    return code.getCode();
  }
}
