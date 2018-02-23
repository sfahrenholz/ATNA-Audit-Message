package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;

/**
 * A.5.3.8 DICOM Study Deleted
 *
 * This message describes the event of deletion of one or more studies and all associated SOP
 * Instances in a single action. This message shall only include information about a single patient.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 */
public class DICOMStudyDeleted extends AuditMessage {

  public DICOMStudyDeleted() {
    super(EventID.DCM_110105, null);
    setEventActionCode(EventActionCodes.DELETE);
  }
}
