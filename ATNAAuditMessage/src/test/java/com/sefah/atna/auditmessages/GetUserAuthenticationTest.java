package com.sefah.atna.auditmessages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.sefah.atna.auditmessages.validator.base.Validator;
import com.sefah.atna.auditmessages.validator.factory.ValidatorFactory;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.exceptions.ValidatorErrorCode;
import com.sefah.atna.exceptions.ValidatorException;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class GetUserAuthenticationTest {

	@Test
	public void testCreatingDefaultmessageLogin() throws Exception {
		final GetUserAuthentication auditMessage = new GetUserAuthentication(EventID.DCM_110122);

		assertEquals(auditMessage.getEvent().getEventID(), EventID.DCM_110114);
		assertEquals(auditMessage.getEvent().getEventTypeCode(), EventID.DCM_110122);

		final Validator instance = ValidatorFactory.getInstance(EventID.DCM_110114);
		try {
			instance.validate(auditMessage);
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_ACTIVE_PARTICANT_1.getCode(), e.getErrorCode());
		}
	}

	@Test
	public void testCreatingDefaultmessageLogout() throws Exception {
		final GetUserAuthentication auditMessage = new GetUserAuthentication(EventID.DCM_110123);

		assertEquals(auditMessage.getEvent().getEventID(), EventID.DCM_110114);
		assertEquals(auditMessage.getEvent().getEventTypeCode(), EventID.DCM_110123);

		final Validator instance = ValidatorFactory.getInstance(EventID.DCM_110114);
		try {
			instance.validate(auditMessage);
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_ACTIVE_PARTICANT_1.getCode(), e.getErrorCode());
		}
	}
}
