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
public class PIXQueryTest {

	@Test
	public void testCreatingDefaultmessage() throws Exception {
		final PIXQuery auditMessage = new PIXQuery();

		assertEquals(auditMessage.getEvent().getEventID(), EventID.DCM_110112);
		assertEquals(auditMessage.getEvent().getEventTypeCode(), EventID.ITI_9);

		final Validator instance = ValidatorFactory.getInstance(EventID.DCM_110112);

		try {
			instance.validate(auditMessage);
			fail("");
		} catch (final ValidatorException e) {
			assertEquals(ValidatorErrorCode.ATNA_ACTIVE_PARTICANT_1.getCode(), e.getErrorCode());
		}
	}
}
