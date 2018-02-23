/**
 *
 */
package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.event.EV;
import com.sefah.atna.exceptions.NotSupportedAuditMessageException;

/**
 * A.5.3.11 Security Alert
 *
 * This message describes any event for which a node needs to report a security alert, e.g., a node
 * authentication failure when establishing a secure communications channel. Note
 *
 * The Node Authentication event can be used to report both successes and failures. If reporting of
 * success is done, this could generate a very large number of audit messages, since every
 * authenticated DICOM association, HL7 transaction, and HTML connection should result in a
 * successful node authentication. It is expected that in most situations only the failures will be
 * reported.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class SecurityAlert extends AuditMessage {

  public SecurityAlert(final EV eventTypeCode) throws NotSupportedAuditMessageException {
    super(EventID.DCM_110113, eventTypeCode);
    setEventActionCode(EventActionCodes.EXECUTE);
    throw new NotSupportedAuditMessageException("Not Supported");
  }

}
