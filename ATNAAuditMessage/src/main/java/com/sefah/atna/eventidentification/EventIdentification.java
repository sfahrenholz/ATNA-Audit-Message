package com.sefah.atna.eventidentification;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.event.EV;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class EventIdentification {

  @XmlElement(name = "EventID")
  private final EV eventID;
  @XmlElement(name = "EventTypeCode")
  private final EV eventTypeCode;
  @XmlAttribute(name = "EventDateTime")
  private Date eventDateTime;
  @XmlAttribute(name = "EventActionCode")
  private String eventActionCode;
  @XmlAttribute(name = "EventOutcomeIndicator")
  private String eventOutcomeIndicator;

  public EventIdentification(final EV eventID, final EV eventTypeCode,
      final EventActionCodes eventActionCode) {
    this.eventID = eventID;
    this.eventTypeCode = eventTypeCode;
    eventDateTime = new Date();
    eventOutcomeIndicator = "0";
    if (eventActionCode != null) {
      this.eventActionCode = eventActionCode.getCode().getCode();
    }
  }

  public EV getEventID() {
    return eventID;
  }

  public EV getEventTypeCode() {
    return eventTypeCode;
  }

  public String getEventActionCode() {
    return eventActionCode;
  }

  public void setEventDateTime(final Date eventDateTime) {
    this.eventDateTime = eventDateTime;
  }

  public Date getEventDateTime() {
    return eventDateTime;
  }

  public String getEventOutcomeIndicator() {
    return eventOutcomeIndicator;
  }

  public void setEventActionCode(final EventActionCodes eventActionCode) {
    this.eventActionCode = eventActionCode.getCode().getCode();
  }

  public void setEventOutcomeIndicator(final String eventOutcomeIndicator) {
    this.eventOutcomeIndicator = eventOutcomeIndicator;
  }

  @Override
  public String toString() {
    return "EventIdentification [eventID=" + eventID + ", eventTypeCode=" + eventTypeCode
        + ", eventActionCode=" + eventActionCode + ", eventDateTime=" + eventDateTime
        + ", eventOutcomeIndicator=" + eventOutcomeIndicator + "]";
  }

}
