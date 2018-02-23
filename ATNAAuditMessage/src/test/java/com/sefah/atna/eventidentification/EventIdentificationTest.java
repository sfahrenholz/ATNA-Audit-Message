package com.sefah.atna.eventidentification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.sefah.atna.codes.EventActionCodes;

public class EventIdentificationTest {

	@Test
	public void testDefault() throws Exception {
		final EventIdentification ei = new EventIdentification(null, null, null);

		assertNull(ei.getEventActionCode());
		assertNotNull(ei.getEventDateTime());
		assertNull(ei.getEventID());
		assertEquals("0", ei.getEventOutcomeIndicator());
		assertNull(ei.getEventTypeCode());
		assertNotNull(ei.toString());

		ei.setEventActionCode(EventActionCodes.CREATE);
		assertNotNull(ei.getEventActionCode());
		assertEquals(EventActionCodes.CREATE.getCode().getCode(), ei.getEventActionCode());
	}
}
