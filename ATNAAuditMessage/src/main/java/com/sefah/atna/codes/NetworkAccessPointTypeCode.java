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
public enum NetworkAccessPointTypeCode {
  /** "1", DNS */
  DNS(new EV("1")),
  /** "2", IP_ADDRESS */
  IP_ADDRESS(new EV("2"));

  @XmlAttribute(name = "NetworkAccessPointTypeCode")
  private EV code;

  private NetworkAccessPointTypeCode(final EV code) {
    this.code = code;
  }

  public EV getCode() {
    return code;
  }

  public Integer getActionCode() {
    return Integer.parseInt(code.getCode());
  }
}
