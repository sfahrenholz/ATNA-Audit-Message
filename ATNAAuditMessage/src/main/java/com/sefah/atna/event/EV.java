package com.sefah.atna.event;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EV {

  @XmlAttribute(name = "csd-code")
  private String code;
  @XmlAttribute(name = "originalText")
  private String originalText;
  @XmlAttribute(name = "codeSystemName")
  private String codeSystemName;

  public EV(final String code, final String codeSystemName, final String originalText) {
    this.code = code;
    this.codeSystemName = codeSystemName;
    this.originalText = originalText;
  }

  public EV(final String code) {
    this(code, null, null);
  }

  public EV(final int code) {
    this(String.valueOf(code), null, null);
  }

  public String getCode() {
    return code;
  }

  public void setCode(final String value) {
    code = value;
  }

  public String getCodeSystemName() {
    return codeSystemName;
  }

  public void setCodeSystemName(final String value) {
    codeSystemName = value;
  }

  public String getOriginalText() {
    return originalText;
  }

  public void setOriginalText(final String value) {
    originalText = value;
  }

  @Override
  public String toString() {
    return "EV [code=" + code + ", originalText=" + originalText + ", codeSystemName="
        + codeSystemName + "]";
  }

  public Integer getActionCodeAsInteger() {
    return Integer.parseInt(code);
  }

}
