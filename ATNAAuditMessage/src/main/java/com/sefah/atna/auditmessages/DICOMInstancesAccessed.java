package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventID;

/**
 * A.5.3.6 DICOM Instances Accessed
 *
 * This message describes the event of DICOM SOP Instances being viewed, utilized, updated, or
 * deleted. This message shall only include information about a single patient and can be used to
 * summarize all activity for several studies for that patient. This message records the studies to
 * which the instances belong, not the individual instances.
 *
 * If all instances within a study are deleted, then the EV(110105, DCM, "DICOM Study Deleted")
 * event shall be used, see Section A.5.3.8.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 */
public class DICOMInstancesAccessed extends AuditMessage {

  public DICOMInstancesAccessed() {
    super(EventID.DCM_110103, null);
  }
}
