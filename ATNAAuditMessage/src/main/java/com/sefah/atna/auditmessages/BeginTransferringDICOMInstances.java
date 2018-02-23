package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;

/**
 * A.5.3.3 Begin Transferring DICOM Instances
 *
 * This message describes the event of a system beginning to transfer a set of DICOM instances from
 * one node to another node within control of the system's security domain. This message may only
 * include information about a single patient.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 */
public class BeginTransferringDICOMInstances extends AuditMessage {

  public BeginTransferringDICOMInstances() {
    super(EventID.DCM_110102, null);
    setEventActionCode(EventActionCodes.READ);
  }
}
