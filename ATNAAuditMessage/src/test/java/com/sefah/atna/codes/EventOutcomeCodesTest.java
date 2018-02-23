package com.sefah.atna.codes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EventOutcomeCodesTest {

	@Test
	public void testTest() throws Exception {
		assertEquals(EventOutcomeCodes.SUCCESS, EventOutcomeCodes.getCodeForInt(0));
		assertEquals(EventOutcomeCodes.SUCCESS, EventOutcomeCodes.getCodeForInt(1));
		assertEquals(EventOutcomeCodes.SUCCESS, EventOutcomeCodes.getCodeForInt(2));
		assertEquals(EventOutcomeCodes.SUCCESS, EventOutcomeCodes.getCodeForInt(3));
		assertEquals(EventOutcomeCodes.MINOR_FAILURE, EventOutcomeCodes.getCodeForInt(4));
		assertEquals(EventOutcomeCodes.SUCCESS, EventOutcomeCodes.getCodeForInt(5));
		assertEquals(EventOutcomeCodes.SUCCESS, EventOutcomeCodes.getCodeForInt(6));
		assertEquals(EventOutcomeCodes.SUCCESS, EventOutcomeCodes.getCodeForInt(7));
		assertEquals(EventOutcomeCodes.SERIOUS_FAILURE, EventOutcomeCodes.getCodeForInt(8));
		assertEquals(EventOutcomeCodes.SUCCESS, EventOutcomeCodes.getCodeForInt(9));
		assertEquals(EventOutcomeCodes.SUCCESS, EventOutcomeCodes.getCodeForInt(10));
		assertEquals(EventOutcomeCodes.SUCCESS, EventOutcomeCodes.getCodeForInt(11));
		assertEquals(EventOutcomeCodes.MAJOR_FAILURE, EventOutcomeCodes.getCodeForInt(12));
	}

	@Test
	public void testSUCCESS() throws Exception {
		assertEquals(0, EventOutcomeCodes.SUCCESS.getActionCode().intValue());

	}

	@Test
	public void testMINOR_FAILURE() throws Exception {
		assertEquals(4, EventOutcomeCodes.MINOR_FAILURE.getActionCode().intValue());

	}

	@Test
	public void testSERIOUS_FAILURE() throws Exception {
		assertEquals(8, EventOutcomeCodes.SERIOUS_FAILURE.getActionCode().intValue());

	}

	@Test
	public void testMAJOR_FAILURE() throws Exception {
		assertEquals(12, EventOutcomeCodes.MAJOR_FAILURE.getActionCode().intValue());

	}
}
