package com.sefah.atna.participantobjectidentification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.sefah.atna.codes.EventID;

public class ParticipantObjectIdentificationTest {

	@Test
	public void testDefault() throws Exception {
		final ParticipantObjectIdentification dummy = new ParticipantObjectIdentification();

		assertNull(dummy.getParticipantObjectDataLifeCycle());
		assertNull(dummy.getParticipantObjectDetail());
		assertNull(dummy.getParticipantObjectID());
		assertNull(dummy.getParticipantObjectIDTypeCode());
		assertNull(dummy.getParticipantObjectName());
		assertNull(dummy.getParticipantObjectQuery());
		assertNull(dummy.getParticipantObjectSensitivity());
		assertNull(dummy.getParticipantObjectTypeCode());
		assertNull(dummy.getParticipantObjectTypeCodeRole());

		assertNull(dummy.getAnonymized());
		assertNull(dummy.getEncrypted());
		assertNull(dummy.getInstances());
		assertNull(dummy.getNumberofinstances());
		assertNotNull(dummy.getAccession());
		assertTrue(dummy.getAccession().isEmpty());
		assertNotNull(dummy.getSopClass());
		assertTrue(dummy.getSopClass().isEmpty());

		assertNotNull(dummy.toString());

		dummy.setParticipantObjectDataLifeCycle(0);
		assertNotNull(dummy.getParticipantObjectDataLifeCycle());
		assertEquals(dummy.getParticipantObjectDataLifeCycle().intValue(), 0);

		dummy.setParticipantObjectDetail("Huhu");

		assertNotNull(dummy.getParticipantObjectDetail());
		assertEquals(dummy.getParticipantObjectDetail(), "Huhu");

		dummy.setParticipantObjectID("Huhu");

		assertNotNull(dummy.getParticipantObjectID());
		assertEquals(dummy.getParticipantObjectID(), "Huhu");

		dummy.setParticipantObjectIDTypeCode(EventID.DCM_110100);

		assertNotNull(dummy.getParticipantObjectIDTypeCode());
		assertEquals(dummy.getParticipantObjectIDTypeCode(), EventID.DCM_110100);

		dummy.setParticipantObjectName("Huhu");

		assertNotNull(dummy.getParticipantObjectName());
		assertEquals(dummy.getParticipantObjectName(), "Huhu");

		dummy.setParticipantObjectQuery("Huhu");

		assertNotNull(dummy.getParticipantObjectQuery());
		assertEquals(dummy.getParticipantObjectQuery(), "Huhu");

		dummy.setParticipantObjectSensitivity("Huhu");

		assertNotNull(dummy.getParticipantObjectSensitivity());
		assertEquals(dummy.getParticipantObjectSensitivity(), "Huhu");

		dummy.setParticipantObjectTypeCode(0);

		assertNotNull(dummy.getParticipantObjectTypeCode());
		assertEquals(dummy.getParticipantObjectTypeCode().intValue(), 0);

		dummy.setParticipantObjectTypeCodeRole(0);

		assertNotNull(dummy.getParticipantObjectTypeCodeRole());
		assertEquals(dummy.getParticipantObjectTypeCodeRole().intValue(), 0);

		dummy.setAnonymized("huhu");
		assertNotNull(dummy.getAnonymized());
		assertEquals(dummy.getAnonymized(), "huhu");

		dummy.setEncrypted("huhu");
		assertNotNull(dummy.getEncrypted());
		assertEquals(dummy.getEncrypted(), "huhu");

		dummy.setNumberofinstances("huhu");
		assertNotNull(dummy.getNumberofinstances());
		assertEquals(dummy.getNumberofinstances(), "huhu");

		dummy.setInstances("huhu");
		assertNotNull(dummy.getInstances());
		assertEquals(dummy.getInstances(), "huhu");

		dummy.setSopClass(new ArrayList<String>());
		dummy.addSOPClass("huhu");
		assertNotNull(dummy.getSopClass());
		assertFalse(dummy.getSopClass().isEmpty());

		dummy.setAccession(new ArrayList<String>());
		dummy.addAccession("huhu");
		assertNotNull(dummy.getAccession());
		assertFalse(dummy.getAccession().isEmpty());

		assertNotNull(dummy.toString());
	}
}
