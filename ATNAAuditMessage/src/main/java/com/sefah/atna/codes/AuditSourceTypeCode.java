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
public enum AuditSourceTypeCode {
  USER_DEVICE(new EV("1", null, "User Device")), DATA_INTERFACE(new EV("2", null,
      "Data Interface")), WEB_SERVER(new EV("3", null, "Web Server")), APPLICATION_SERVER(
          new EV("4", null, "Application Server")), DATABASE_SERVER(
              new EV("5", null, "Data Server")), SECURITY_SERVER(
                  new EV("6", null, "Secruity Server")), NETWORK_DEVICE(
                      new EV("7", null, "Network Device")), NETWORK_ROUTER(
                          new EV("8", null, "Network Router")), OTHER(new EV("9", null, "Other"));

  @XmlAttribute(name = "AuditSourceTypeCode")
  private EV code;

  private AuditSourceTypeCode(final EV code) {
    this.code = code;
  }

  public EV getCode() {
    return code;
  }

}
