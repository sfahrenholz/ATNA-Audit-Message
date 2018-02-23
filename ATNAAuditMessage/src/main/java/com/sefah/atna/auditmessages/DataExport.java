package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;

/**
 * A.5.3.4 Data Export
 *
 * This message describes the event of exporting data from a system, meaning that the data is
 * leaving control of the system's security domain. Examples of exporting include printing to paper,
 * recording on film, conversion to another format for storage in an EHR, writing to removable
 * media, or sending via e-mail. Multiple patients may be described in one event message.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 */
public class DataExport extends AuditMessage {

  public DataExport() {
    super(EventID.DCM_110106, null);
    setEventActionCode(EventActionCodes.READ);
  }
}
