package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.event.EV;

/**
 * <strong>Get User Authentication [ITI-2] </strong><br />
 * This section corresponds to Transaction ITI-2 of the IHE IT Infrastructure Technical Framework.
 * <br />
 * Transaction ITI-2 is used by the Client Authentication Agent and Kerberos Authentication Server
 * Actors. <br/>
 * <strong>A.5.3.12 User Authentication</strong><br />
 *
 * This message describes the event that a user has attempted to log on or log off. This report can
 * be made regardless of whether the attempt was successful or not. No Participant Objects are
 * needed for this message. Note
 *
 * The user usually has UserIsRequestor TRUE, but in the case of a logout timer, the Node might be
 * the UserIsRequestor.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class GetUserAuthentication extends AuditMessage {

  public GetUserAuthentication(final EV eventTypeCode) {
    super(EventID.DCM_110114, eventTypeCode);
    setEventActionCode(EventActionCodes.EXECUTE);
  }

}
