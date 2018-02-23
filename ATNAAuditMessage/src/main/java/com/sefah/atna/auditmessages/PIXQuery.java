package com.sefah.atna.auditmessages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;

/**
 * This section corresponds to transaction ITI-9 of the IHE IT Infrastructure Technical Framework.
 * Transaction ITI-9 is used by the Patient Identifier Cross-reference Consumer and Patient 1330
 * Identifier Cross-reference Manager Actors
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PIXQuery extends AuditMessage {

  public PIXQuery() {
    super(EventID.DCM_110112, EventID.ITI_9);
    setEventActionCode(EventActionCodes.EXECUTE);
  }
}
