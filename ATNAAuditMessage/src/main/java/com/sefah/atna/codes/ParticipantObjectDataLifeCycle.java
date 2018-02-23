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
public enum ParticipantObjectDataLifeCycle {
  ORIGINATION_OR_CREATION(new EV(1)), IMPORT_OR_COPY_FROM_ORIGINAL(new EV(2)), AMENDMENT(
      new EV(3)), VERIFICATION(
          new EV(4)), TRANSLATION(new EV(5)), ACCESS_OR_USE(new EV(6)), DE_IDENTIFICATION(
              new EV(7)), AGGREGATION(new EV(8)), REPORT(new EV(9)), EXPORT_OR_COPY_TO_TARGET(
                  new EV(10)), DISCLOSURE(new EV(11)), RECEIPT_OF_DISCLOSURE(new EV(12)), ARCHIVING(
                      new EV(13)), LOGICAL_DELETION(
                          new EV(14)), PERMANENT_ERASURE_PHYSICAL_DESTRUCTION(new EV(15));

  @XmlAttribute(name = "ParticipantObjectDataLifeCycle")
  private EV code;

  private ParticipantObjectDataLifeCycle(final EV code) {
    this.code = code;
  }

  public Integer getCode() {
    return code.getActionCodeAsInteger();
  }
}
