package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;

/**
 * ITI-21 Patient Demographics Query
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 */
public class PatientDemographicsQuery extends AuditMessage {

  public PatientDemographicsQuery() {
    super(EventID.DCM_110112, EventID.ITI_21);
    setEventActionCode(EventActionCodes.EXECUTE);
  }
}
