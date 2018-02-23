package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventID;

/**
 * A.5.3.13 Order Record
 *
 * This message describes the event of an order being created, modified, accessed, or deleted. This
 * message may only include information about a single patient. Note
 *
 * An order record typically is managed by a non-DICOM system. However, DICOM applications often
 * manipulate order records, and thus may be obligated by site security policies to record such
 * events in the audit logs.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class OrderRecord extends AuditMessage {

  public OrderRecord() {
    super(EventID.DCM_110109, null);
  }
}
