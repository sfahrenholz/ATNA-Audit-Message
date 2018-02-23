/**
 *
 */
package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.exceptions.NotSupportedAuditMessageException;

/**
 * A.5.3.10 Query
 *
 * This message describes the event of a Query being issued or received. The message does not record
 * the response to the query, but merely records the fact that a query was issued. For example, this
 * would report queries using the DICOM SOP Classes:
 *
 * Modality Worklist
 *
 * UPS Pull
 *
 * UPS Watch
 *
 * Composite Instance Query
 *
 * Note
 *
 * The response to a query may result in one or more Instances Transferred or Instances Accessed
 * messages, depending on what events transpire after the query. If there were security-related
 * failures, such as access violations, when processing a query, those failures should show up in
 * other audit messages, such as a Security Alert message.
 *
 * Non-DICOM queries may also be captured by this message. The Participant Object ID Type Code, the
 * Participant Object ID, and the Query fields may have values related to such non-DICOM queries.
 *
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class Query extends AuditMessage {

  public Query() throws NotSupportedAuditMessageException {
    super(EventID.DCM_110112, null);
    setEventActionCode(EventActionCodes.EXECUTE);
    throw new NotSupportedAuditMessageException("Not Supported");
  }
}
