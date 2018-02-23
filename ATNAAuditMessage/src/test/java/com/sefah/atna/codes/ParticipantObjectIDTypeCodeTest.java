package com.sefah.atna.codes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParticipantObjectIDTypeCodeTest {

	@Test
	public void testPatientID() throws Exception {
		assertEquals("2", ParticipantObjectIDTypeCode.PATIENT_ID.getCode().getCode());
	}

	@Test
	public void testURI() throws Exception {
		assertEquals("12", ParticipantObjectIDTypeCode.URI.getCode().getCode());
	}
}
