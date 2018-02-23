package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;

/**
 * ITI-22 Patient Demographic Visit Query
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 */
public class PatientDemographicVisitQuery extends AuditMessage {

  public PatientDemographicVisitQuery() {
    super(EventID.DCM_110112, EventID.ITI_22);
    setEventActionCode(EventActionCodes.EXECUTE);
  }
}
