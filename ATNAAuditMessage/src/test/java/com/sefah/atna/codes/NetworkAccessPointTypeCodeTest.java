package com.sefah.atna.codes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NetworkAccessPointTypeCodeTest {

	@Test
	public void testDNS() throws Exception {
		assertEquals(1, NetworkAccessPointTypeCode.DNS.getActionCode().intValue());
	}

	@Test
	public void testIP_ADDRESS() throws Exception {
		assertEquals(2, NetworkAccessPointTypeCode.IP_ADDRESS.getActionCode().intValue());
	}
}
