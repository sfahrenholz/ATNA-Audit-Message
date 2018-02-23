package com.sefah.atna.auditmessages;

import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.event.EV;

/**
 * A.5.3.9 Network Entry
 *
 * This message describes the event of a system, such as a mobile device, intentionally entering or
 * leaving the network. Note
 *
 * The machine should attempt to send this message prior to detaching. If this is not possible, it
 * should retain the message in a local buffer so that it can be sent later. The mobile machine can
 * then capture audit messages in a local buffer while it is outside the secure domain. When it is
 * reconnected to the secure domain, it can send the detach message (if buffered), followed by the
 * buffered messages, followed by a mobile machine message for rejoining the secure domain. The
 * timestamps on these messages is the time that the event was noticed to have occurred, not the
 * time that the message is sent.
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class NetworkEntry extends AuditMessage {

  public NetworkEntry(final EV eventTypeCode) {
    super(EventID.DCM_110108, eventTypeCode);
    setEventActionCode(EventActionCodes.EXECUTE);
  }
}
