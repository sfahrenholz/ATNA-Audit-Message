package com.sefah.atna.codes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParticipantObjectTypeCodeRoleTest {
	@Test
	public void testJOB() throws Exception {
		assertEquals(20, ParticipantObjectTypeCodeRole.JOB.getActionCode().intValue());
	}

	@Test
	public void testPATIENT() throws Exception {
		assertEquals(1, ParticipantObjectTypeCodeRole.PATIENT.getActionCode().intValue());
	}

	@Test
	public void testQUERY() throws Exception {
		assertEquals(24, ParticipantObjectTypeCodeRole.QUERY.getActionCode().intValue());
	}

	@Test
	public void testREPORT() throws Exception {
		assertEquals(3, ParticipantObjectTypeCodeRole.REPORT.getActionCode().intValue());
	}

}
