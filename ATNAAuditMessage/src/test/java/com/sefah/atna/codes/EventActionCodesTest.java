package com.sefah.atna.codes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EventActionCodesTest {

	@Test
	public void testCREATE() throws Exception {
		assertEquals("C", EventActionCodes.CREATE.getActionCode());
	}

	@Test
	public void testDELETE() throws Exception {
		assertEquals("D", EventActionCodes.DELETE.getActionCode());
	}

	@Test
	public void testEXECUTE() throws Exception {
		assertEquals("E", EventActionCodes.EXECUTE.getActionCode());
	}

	@Test
	public void testREAD() throws Exception {
		assertEquals("R", EventActionCodes.READ.getActionCode());
	}

	@Test
	public void testUPDATE() throws Exception {
		assertEquals("U", EventActionCodes.UPDATE.getActionCode());
	}
}
