package com.sefah.atna.auditsourceidentification;

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
public class AuditSourceIdentification {

  @XmlAttribute(name = "AuditSourceID")
  private String auditSourceID;
  @XmlAttribute(name = "AuditEnterpriseSiteID")
  private String auditEnterpriseSiteID;
  @XmlAttribute(name = "AuditSourceTypeCode")
  private String auditSourceTypeCode;

  public String getAuditSourceID() {
    return auditSourceID;
  }

  public void setAuditSourceID(final String auditSourceID) {
    this.auditSourceID = auditSourceID;
  }

  public String getAuditEnterpriseSiteID() {
    return auditEnterpriseSiteID;
  }

  public void setAuditEnterpriseSiteID(final String auditEnterpriseSiteID) {
    this.auditEnterpriseSiteID = auditEnterpriseSiteID;
  }

  public String getAuditSourceTypeCode() {
    return auditSourceTypeCode;
  }

  public void setAuditSourceTypeCode(final String auditSourceTypeCode) {
    this.auditSourceTypeCode = auditSourceTypeCode;
  }

}
