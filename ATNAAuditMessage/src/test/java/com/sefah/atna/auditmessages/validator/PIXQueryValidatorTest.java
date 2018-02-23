package com.sefah.atna.auditmessages.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.auditsourceidentification.AuditSourceIdentification;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.event.EV;
import com.sefah.atna.exceptions.ValidatorErrorCode;
import com.sefah.atna.exceptions.ValidatorException;
import com.sefah.atna.participantobjectidentification.ParticipantObjectIdentification;

public class PIXQueryValidatorTest {

	class TestAuditMessage extends AuditMessage {

		public TestAuditMessage(final EV dCM_110130, final EV dCM_1101302) {
			super(dCM_110130, dCM_1101302);
			setEventActionCode(EventActionCodes.CREATE);
		}

		public TestAuditMessage() {
		}
	}

	@Test
	public void testCheckActiveParticipantIs1() throws Exception {
		final PIXQueryValidator validator = new PIXQueryValidator();
		final TestAuditMessage testAuditMessage = new TestAuditMessage(EventID.DCM_110130, EventID.DCM_110130);

		testAuditMessage.addActiveParticipant(new ActiveParticipant());
		testAuditMessage.addActiveParticipant(new ActiveParticipant());
		try {
			validator.validate(testAuditMessage);
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_ACTIVE_PARTICANT_1.getCode(), e.getErrorCode());
		}
	}

	@Test
	public void testCheckAuditSourceIdentificationIs1() throws Exception {
		final PIXQueryValidator validator = new PIXQueryValidator();
		final TestAuditMessage testAuditMessage = new TestAuditMessage(EventID.DCM_110130, EventID.DCM_110130);

		testAuditMessage.addActiveParticipant(new ActiveParticipant());
		testAuditMessage.addAuditSourceIdentification(new AuditSourceIdentification());
		testAuditMessage.addAuditSourceIdentification(new AuditSourceIdentification());
		try {
			validator.validate(testAuditMessage);
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_AUDIT_SOURCE_1.getCode(), e.getErrorCode());
		}
	}

	@Test
	public void testCheckParticipantObjectIdentificationIs1() throws Exception {
		final PIXQueryValidator validator = new PIXQueryValidator();
		final TestAuditMessage testAuditMessage = new TestAuditMessage(EventID.DCM_110130, EventID.DCM_110130);

		testAuditMessage.addActiveParticipant(new ActiveParticipant());
		testAuditMessage.addAuditSourceIdentification(new AuditSourceIdentification());
		testAuditMessage.addParticipantObjectIdentification(new ParticipantObjectIdentification());
		testAuditMessage.addParticipantObjectIdentification(new ParticipantObjectIdentification());

		try {
			validator.validate(testAuditMessage);
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_PARTICIPANT_OBJECT_1.getCode(), e.getErrorCode());
		}
	}

	@Test
	public void testGetUserAuthenticationValidtor() throws Exception {
		final PIXQueryValidator validator = new PIXQueryValidator();

		try {
			validator.validate(null);
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_MESSAGE_NULL.getCode(), e.getErrorCode());
		}
		try {
			validator.validate(new TestAuditMessage());
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_MISSING_REQ_EVENTINFORMATION.getCode(), e.getErrorCode());
		}

		final TestAuditMessage testAuditMessage = new TestAuditMessage(EventID.DCM_110130, EventID.DCM_110130);
		try {
			validator.validate(testAuditMessage);
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_ACTIVE_PARTICANT_1.getCode(), e.getErrorCode());
		}

		testAuditMessage.addActiveParticipant(new ActiveParticipant());
		try {
			validator.validate(testAuditMessage);
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_AUDIT_SOURCE_1.getCode(), e.getErrorCode());
		}

		testAuditMessage.addAuditSourceIdentification(new AuditSourceIdentification());
		try {
			validator.validate(testAuditMessage);
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_PARTICIPANT_OBJECT_1.getCode(), e.getErrorCode());
		}

		testAuditMessage.addParticipantObjectIdentification(new ParticipantObjectIdentification());
		assertTrue(validator.validate(testAuditMessage));
	}
}
