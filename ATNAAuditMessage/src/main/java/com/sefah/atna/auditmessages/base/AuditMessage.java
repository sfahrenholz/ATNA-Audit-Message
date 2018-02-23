package com.sefah.atna.auditmessages.base;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditsourceidentification.AuditSourceIdentification;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.event.EV;
import com.sefah.atna.eventidentification.EventIdentification;
import com.sefah.atna.participantobjectidentification.ParticipantObjectIdentification;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "AuditMessage")
public abstract class AuditMessage {

  @XmlElement(name = "EventIdentification")
  protected EventIdentification event;
  @XmlElement(name = "ActiveParticipant")
  protected List<ActiveParticipant> activeParticipant;
  @XmlElement(name = "AuditSourceIdentification")
  protected List<AuditSourceIdentification> auditSource;
  @XmlElement(name = "ParticipantObjectIdentification")
  protected List<ParticipantObjectIdentification> participantObject;

  protected AuditMessage() {
    // JAXB
  }

  public AuditMessage(final EV eventID, final EV eventTypeCode) {
    this(eventID, eventTypeCode, null);
  }

  public AuditMessage(final EV eventID, final EV eventTypeCode,
      final EventActionCodes eventOutcomeIndicator) {
    event = new EventIdentification(eventID, eventTypeCode, eventOutcomeIndicator);

    auditSource = new ArrayList<>();
    participantObject = new ArrayList<>();
    activeParticipant = new ArrayList<>();
  }

  protected void setEventActionCode(final EventActionCodes eventActionCode) {
    event.setEventActionCode(eventActionCode);
  }

  public void addActiveParticipant(final ActiveParticipant value) {
    activeParticipant.add(value);
  }

  public void addAuditSourceIdentification(final AuditSourceIdentification value) {
    auditSource.add(value);
  }

  public void addParticipantObjectIdentification(final ParticipantObjectIdentification value) {
    participantObject.add(value);
  }

  public EventIdentification getEvent() {
    return event;
  }

  public List<ActiveParticipant> getActiveParticipant() {
    return activeParticipant;
  }

  public List<AuditSourceIdentification> getAuditSource() {
    return auditSource;
  }

  public List<ParticipantObjectIdentification> getParticipantObject() {
    return participantObject;
  }

}
