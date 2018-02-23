package com.sefah.atna.participantobjectidentification;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.sefah.atna.event.EV;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantObjectIdentification {

  @XmlAttribute(name = "ParticipantObjectIDTypeCode")
  private Integer participantObjectTypeCode;
  @XmlAttribute(name = "ParticipantObjectTypeCodeRole")
  private Integer participantObjectTypeCodeRole;
  @XmlAttribute(name = "ParticipantObjectDataLifeCycle")
  private Integer participantObjectDataLifeCycle;
  @XmlElement(name = "ParticipantObjectIDTypeCode")
  private EV participantObjectIDTypeCode;
  @XmlAttribute(name = "ParticipantObjectSensitivity")
  private String participantObjectSensitivity;
  @XmlAttribute(name = "ParticipantObjectID")
  private String participantObjectID;
  @XmlAttribute(name = "ParticipantObjectName")
  private String participantObjectName;
  @XmlAttribute(name = "ParticipantObjectQuery")
  private String participantObjectQuery;
  @XmlAttribute(name = "ParticipantObjectDetail")
  private String participantObjectDetail;

  @XmlElement(name = "SOPClass")
  private List<String> sopClass;
  @XmlElement(name = "Accession")
  private List<String> accession;
  @XmlAttribute(name = "NumberOfInstances")
  private String numberOfInstances;
  @XmlAttribute(name = "Instances")
  private String instances;
  @XmlAttribute(name = "Encrypted")
  private String encrypted;
  @XmlAttribute(name = "Anonymized")
  private String anonymized;

  public ParticipantObjectIdentification() {
    sopClass = new ArrayList<>();
    accession = new ArrayList<>();
  }

  public Integer getParticipantObjectTypeCode() {
    return participantObjectTypeCode;
  }

  public void setParticipantObjectTypeCode(final Integer participantObjectTypeCode) {
    this.participantObjectTypeCode = participantObjectTypeCode;
  }

  public Integer getParticipantObjectTypeCodeRole() {
    return participantObjectTypeCodeRole;
  }

  public void setParticipantObjectTypeCodeRole(final Integer participantObjectTypeCodeRole) {
    this.participantObjectTypeCodeRole = participantObjectTypeCodeRole;
  }

  public Integer getParticipantObjectDataLifeCycle() {
    return participantObjectDataLifeCycle;
  }

  public void setParticipantObjectDataLifeCycle(final Integer participantObjectDataLifeCycle) {
    this.participantObjectDataLifeCycle = participantObjectDataLifeCycle;
  }

  public EV getParticipantObjectIDTypeCode() {
    return participantObjectIDTypeCode;
  }

  public void setParticipantObjectIDTypeCode(final EV participantObjectIDTypeCode) {
    this.participantObjectIDTypeCode = participantObjectIDTypeCode;
  }

  public String getParticipantObjectSensitivity() {
    return participantObjectSensitivity;
  }

  public void setParticipantObjectSensitivity(final String participantObjectSensitivity) {
    this.participantObjectSensitivity = participantObjectSensitivity;
  }

  public String getParticipantObjectID() {
    return participantObjectID;
  }

  public void setParticipantObjectID(final String participantObjectID) {
    this.participantObjectID = participantObjectID;
  }

  public String getParticipantObjectName() {
    return participantObjectName;
  }

  public void setParticipantObjectName(final String participantObjectName) {
    this.participantObjectName = participantObjectName;
  }

  public String getParticipantObjectQuery() {
    return participantObjectQuery;
  }

  public void setParticipantObjectQuery(final String participantObjectQuery) {
    this.participantObjectQuery = participantObjectQuery;
  }

  public String getParticipantObjectDetail() {
    return participantObjectDetail;
  }

  public void setParticipantObjectDetail(final String participantObjectDetail) {
    this.participantObjectDetail = participantObjectDetail;
  }

  public List<String> getSopClass() {
    return sopClass;
  }

  public void addSOPClass(final String string) {
    if (!sopClass.contains(string)) {
      sopClass.add(string);
    }
  }

  public void setSopClass(final List<String> sopClass) {
    this.sopClass = sopClass;
  }

  public List<String> getAccession() {
    return accession;
  }

  public void addAccession(final String string) {
    if (!accession.contains(string)) {
      accession.add(string);
    }
  }

  public void setAccession(final List<String> accession) {
    this.accession = accession;
  }

  public String getNumberofinstances() {
    return numberOfInstances;
  }

  public void setNumberofinstances(final String numberofinstances) {
    numberOfInstances = numberofinstances;
  }

  public String getInstances() {
    return instances;
  }

  public void setInstances(final String instances) {
    this.instances = instances;
  }

  public String getEncrypted() {
    return encrypted;
  }

  public void setEncrypted(final String encrypted) {
    this.encrypted = encrypted;
  }

  public String getAnonymized() {
    return anonymized;
  }

  public void setAnonymized(final String anonymized) {
    this.anonymized = anonymized;
  }

  public void setParticipantObjectTypeCode(final EV code) {
    setParticipantObjectTypeCode(code.getActionCodeAsInteger());
  }
}
