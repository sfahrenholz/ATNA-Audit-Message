package com.sefah.atna.auditmessages.base;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sefah.atna.codes.EventID;
import com.sefah.atna.participantobjectidentification.ParticipantObjectIdentification;

public class AuditMessageTest {
	class BaseAuditMessage extends AuditMessage {

		public BaseAuditMessage() {
			super(EventID.DCM_110150, EventID.DCM_110120);
		}
	}

	@Test
	public void testDefaultMessage() throws Exception {
		final AuditMessage msg = new BaseAuditMessage();

		assertNotNull(msg.getActiveParticipant());
		assertTrue(msg.getActiveParticipant().isEmpty());
		assertNotNull(msg.getAuditSource());
		assertTrue(msg.getAuditSource().isEmpty());
		assertNotNull(msg.getParticipantObject());
		assertTrue(msg.getParticipantObject().isEmpty());
	}

	@Test
	public void testAddParticipantObjectIdentification() throws Exception {
		final AuditMessage msg = new BaseAuditMessage();

		assertNotNull(msg.getParticipantObject());
		assertTrue(msg.getParticipantObject().isEmpty());

		msg.addParticipantObjectIdentification(new ParticipantObjectIdentification());
		assertNotNull(msg.getParticipantObject());
		assertFalse(msg.getParticipantObject().isEmpty());
	}
}
