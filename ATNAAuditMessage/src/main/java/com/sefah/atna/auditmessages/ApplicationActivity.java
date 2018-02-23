package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.event.EV;

/**
 * A.5.3.1 Application Activity
 *
 * This audit message describes the event of an Application Entity starting or stopping. This is
 * closely related to the more general case of any kind of application startup or shutdown, and may
 * be suitable for those purposes also.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 */
public class ApplicationActivity extends AuditMessage {

  public ApplicationActivity(final EV eventTypeCode) {
    super(EventID.DCM_110100, eventTypeCode);
    setEventActionCode(EventActionCodes.EXECUTE);
  }
}
