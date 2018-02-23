package com.sefah.atna.auditsourceidentification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AuditSourceIdentificationTest {

	@Test
	public void testDefault() throws Exception {
		final AuditSourceIdentification dummy = new AuditSourceIdentification();

		assertNull(dummy.getAuditEnterpriseSiteID());
		assertNull(dummy.getAuditSourceID());
		assertNull(dummy.getAuditSourceTypeCode());
		assertNotNull(dummy.toString());

		dummy.setAuditEnterpriseSiteID("Huhu");

		assertNotNull(dummy.getAuditEnterpriseSiteID());
		assertEquals(dummy.getAuditEnterpriseSiteID(), "Huhu");

		dummy.setAuditSourceID("Huhu");

		assertNotNull(dummy.getAuditSourceID());
		assertEquals(dummy.getAuditSourceID(), "Huhu");

		dummy.setAuditSourceTypeCode("Huhu");

		assertNotNull(dummy.getAuditSourceTypeCode());
		assertEquals(dummy.getAuditSourceTypeCode(), "Huhu");

		assertNotNull(dummy.toString());
	}
}
