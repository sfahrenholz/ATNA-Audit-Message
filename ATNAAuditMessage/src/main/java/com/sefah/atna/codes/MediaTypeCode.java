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
public enum MediaTypeCode {
  /** "110030", USB Disk Emulation */
  USB("110030", "DCM", "USB Disk Emulation"),
  /** "110031", Email */
  EMAIL("110031", "DCM", "Email"),
  /** "110032", CD */
  CD("110032", "DCM", "CD"),
  /** "110033",DVD */
  DVD("110033", "DCM", "DVD"),
  /** "110034", USB Disk Emulation */
  COMPACT_FLASH("110034", "DCM", " Compact Flash"),
  /** "110035", Multi-media Card */
  MMC("110035", "DCM", "Multi-media Card"),
  /** "110036", Secure Digital Card */
  SD("110036", "DCM", " Secure Digital Card"),
  /** "110037", URI */
  URI("110037", "DCM", "URI"),
  /** "110038", Film */
  FILM("110038", "DCM", "Film"),
  /** "110039", Paper Document */
  PAPER_DOCUMENT("110039", "DCM", "Paper Document");

  @XmlAttribute(name = "MediaTypeCode")
  private EV code;

  private MediaTypeCode(final String code, final String name, final String originalValue) {
    this.code = new EV(code, name, originalValue);
  }

  public EV getCode() {
    return code;
  }
}
