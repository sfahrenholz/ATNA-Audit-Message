package com.sefah.atna;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.ApplicationActivity;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.tools.AuditMessageXMLConverter;

public class Starter {

  public static void main(final String[] args) {
    final AuditMessage message = new ApplicationActivity(EventID.DCM_110120);

    final ActiveParticipant started = new ActiveParticipant();
    started.setUserID("123456");
    started.setAlternativeUserID("123456");
    started.setRoleIDCode(EventID.DCM_110150);

    message.addActiveParticipant(started);

    final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
    System.out.println(conv.convertXMLToString(message));
  }
}
