package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;

/**
 * A.5.3.5 Data Import
 *
 * This message describes the event of importing data into an organization, implying that the data
 * now entering the system was not under the control of the security domain of this organization.
 * Transfer by media within an organization is often considered a data transfer rather than a data
 * import event. An example of importing is creating new local instances from data on removable
 * media. Multiple patients may be described in one event message.
 *
 * A single user (either local or remote) shall be identified as the requestor, i.e.,
 * UserIsRequestor with a value of TRUE. This accommodates both push and pull transfer models for
 * media.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 */
public class DataImport extends AuditMessage {

  public DataImport() {
    super(EventID.DCM_110107, null);
    setEventActionCode(EventActionCodes.CREATE);
  }
}
