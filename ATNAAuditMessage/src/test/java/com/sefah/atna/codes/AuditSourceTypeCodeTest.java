package com.sefah.atna.codes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AuditSourceTypeCodeTest {
	@Test
	public void test1() throws Exception {
		assertEquals("1", AuditSourceTypeCode.USER_DEVICE.getCode().getCode());
	}

	@Test
	public void test2() throws Exception {
		assertEquals("2", AuditSourceTypeCode.DATA_INTERFACE.getCode().getCode());
	}

	@Test
	public void test3() throws Exception {
		assertEquals("3", AuditSourceTypeCode.WEB_SERVER.getCode().getCode());
	}

	@Test
	public void test4() throws Exception {
		assertEquals("4", AuditSourceTypeCode.APPLICATION_SERVER.getCode().getCode());
	}

	@Test
	public void test5() throws Exception {
		assertEquals("5", AuditSourceTypeCode.DATABASE_SERVER.getCode().getCode());
	}

	@Test
	public void test6() throws Exception {
		assertEquals("6", AuditSourceTypeCode.SECURITY_SERVER.getCode().getCode());
	}

	@Test
	public void test7() throws Exception {
		assertEquals("7", AuditSourceTypeCode.NETWORK_DEVICE.getCode().getCode());
	}

	@Test
	public void test8() throws Exception {
		assertEquals("8", AuditSourceTypeCode.NETWORK_ROUTER.getCode().getCode());
	}

	@Test
	public void test9() throws Exception {
		assertEquals("9", AuditSourceTypeCode.OTHER.getCode().getCode());
	}
}
