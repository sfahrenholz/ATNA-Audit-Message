package com.sefah.atna.activeparticipant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.sefah.atna.codes.NetworkAccessPointTypeCode;
import com.sefah.atna.event.EV;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ActiveParticipant {

  @XmlAttribute(name = "UserID")
  private String userID;
  @XmlAttribute(name = "AlternativUserID")
  private String alternativeUserID;
  @XmlAttribute(name = "UserName")
  private String userName;
  @XmlAttribute(name = "UserIsRequestor")
  private Boolean userIsRequestor;
  @XmlElement(name = "RoleIDCode")
  private EV roleIDCode;
  @XmlAttribute(name = "NetworkAccessPointTypeCode")
  private Integer networkAccessPointTypeCode;
  @XmlAttribute(name = "NetworkAccessPointID")
  private String networkAccessPointID;
  @XmlAttribute(name = "MediaIdentifier")
  private String mediaIdentifier;
  @XmlElement(name = "MediaType")
  private EV mediaType;

  public String getUserID() {
    return userID;
  }

  public void setUserID(final String userID) {
    this.userID = userID;
  }

  public String getAlternativeUserID() {
    return alternativeUserID;
  }

  public void setAlternativeUserID(final String alternativeUserID) {
    this.alternativeUserID = alternativeUserID;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(final String userName) {
    this.userName = userName;
  }

  public Boolean getUserIsRequestor() {
    return userIsRequestor;
  }

  public void setUserIsRequestor(final Boolean userIsRequestor) {
    this.userIsRequestor = userIsRequestor;
  }

  public EV getRoleIDCode() {
    return roleIDCode;
  }

  public Integer getNetworkAccessPointTypeCode() {
    return networkAccessPointTypeCode;
  }

  public void setNetworkAccessPointTypeCode(final Integer networkAccessPointTypeCode) {
    this.networkAccessPointTypeCode = networkAccessPointTypeCode;
  }

  public String getNetworkAccessPointID() {
    return networkAccessPointID;
  }

  public void setNetworkAccessPointID(final String networkAccessPointID) {
    this.networkAccessPointID = networkAccessPointID;
  }

  public void setRoleIDCode(final EV roleIDCode) {
    this.roleIDCode = roleIDCode;
  }

  public void setNetworkAccessPointTypeCode(final NetworkAccessPointTypeCode ipAddress) {
    setNetworkAccessPointTypeCode(ipAddress.getActionCode());
  }

  public String getMediaIdentifier() {
    return mediaIdentifier;
  }

  public void setMediaIdentifier(final String mediaIdentifier) {
    this.mediaIdentifier = mediaIdentifier;
  }

  public EV getMediaType() {
    return mediaType;
  }

  public void setMediaType(final EV mediaType) {
    this.mediaType = mediaType;
  }

}
