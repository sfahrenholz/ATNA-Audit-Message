package com.sefah.atna.codes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParticipantObjectTypeCodeTest {

	@Test
	public void testPERSON() throws Exception {
		assertEquals(1, ParticipantObjectTypeCode.PERSON.getActionCode().intValue());
	}

	@Test
	public void testSYSTEM() throws Exception {
		assertEquals(2, ParticipantObjectTypeCode.SYSTEM.getActionCode().intValue());
	}

	@Test
	public void testSYSTEM_OBJECT() throws Exception {
		assertEquals(2, ParticipantObjectTypeCode.SYSTEM_OBJECT.getActionCode().intValue());
	}

	@Test
	public void testORGANIZATION() throws Exception {
		assertEquals(3, ParticipantObjectTypeCode.ORGANIZATION.getActionCode().intValue());
	}

	@Test
	public void testOTHER() throws Exception {
		assertEquals(4, ParticipantObjectTypeCode.OTHER.getActionCode().intValue());
	}
}
