package com.sefah.atna.activeparticipant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.sefah.atna.codes.EventID;

public class ActiveParticipantTest {

	@Test
	public void testDestinationActiveParticipant() throws Exception {
		final ActiveParticipant dummy = new ActiveParticipant();

		assertNull(dummy.getAlternativeUserID());
		assertNull(dummy.getNetworkAccessPointID());
		assertNull(dummy.getNetworkAccessPointTypeCode());
		assertNull(dummy.getRoleIDCode());
		assertNull(dummy.getUserID());
		assertNull(dummy.getUserIsRequestor());
		assertNull(dummy.getUserName());
		assertNotNull(dummy.toString());

		dummy.setAlternativeUserID("huhu");
		assertNotNull(dummy.getAlternativeUserID());
		assertEquals(dummy.getAlternativeUserID(), "huhu");

		dummy.setNetworkAccessPointID("huhu");
		assertNotNull(dummy.getNetworkAccessPointID());
		assertEquals("huhu", dummy.getNetworkAccessPointID());

		dummy.setNetworkAccessPointTypeCode(0);
		assertNotNull(dummy.getNetworkAccessPointTypeCode());
		assertEquals(dummy.getNetworkAccessPointTypeCode().intValue(), 0);

		dummy.setRoleIDCode(EventID.DCM_110150);
		assertNotNull(dummy.getRoleIDCode());
		assertEquals(dummy.getRoleIDCode(), EventID.DCM_110150);

		dummy.setUserID("huhu");
		assertNotNull(dummy.getUserID());
		assertEquals(dummy.getUserID(), "huhu");

		dummy.setUserIsRequestor(true);
		assertNotNull(dummy.getUserIsRequestor());
		assertEquals(dummy.getUserIsRequestor(), true);

		dummy.setUserName("huhu");
		assertNotNull(dummy.getUserName());
		assertEquals(dummy.getUserName(), "huhu");

		assertNotNull(dummy.toString());
	}
}
