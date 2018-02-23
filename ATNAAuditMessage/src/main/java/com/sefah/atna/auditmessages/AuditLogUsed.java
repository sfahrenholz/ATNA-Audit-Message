package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;

/**
 * A.5.3.2 Audit Log Used
 *
 * This message describes the event of a person or process reading a log of audit trail information.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class AuditLogUsed extends AuditMessage {

  public AuditLogUsed() {
    super(EventID.DCM_110101, null);
    setEventActionCode(EventActionCodes.READ);
  }
}
