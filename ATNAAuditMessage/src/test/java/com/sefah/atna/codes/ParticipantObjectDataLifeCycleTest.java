package com.sefah.atna.codes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ParticipantObjectDataLifeCycleTest {

	@Test
	public void test1() throws Exception {
		assertEquals(6, ParticipantObjectDataLifeCycle.ACCESS_OR_USE.getCode().intValue());
	}

	@Test
	public void test2() throws Exception {
		assertEquals(8, ParticipantObjectDataLifeCycle.AGGREGATION.getCode().intValue());
	}

	@Test
	public void test3() throws Exception {
		assertEquals(3, ParticipantObjectDataLifeCycle.AMENDMENT.getCode().intValue());
	}

	@Test
	public void test4() throws Exception {
		assertEquals(13, ParticipantObjectDataLifeCycle.ARCHIVING.getCode().intValue());
	}

	@Test
	public void test5() throws Exception {
		assertEquals(7, ParticipantObjectDataLifeCycle.DE_IDENTIFICATION.getCode().intValue());
	}

	@Test
	public void test6() throws Exception {
		assertEquals(11, ParticipantObjectDataLifeCycle.DISCLOSURE.getCode().intValue());
	}

	@Test
	public void test7() throws Exception {
		assertEquals(10, ParticipantObjectDataLifeCycle.EXPORT_OR_COPY_TO_TARGET.getCode().intValue());
	}

	@Test
	public void test8() throws Exception {
		assertEquals(2, ParticipantObjectDataLifeCycle.IMPORT_OR_COPY_FROM_ORIGINAL.getCode().intValue());
	}

	@Test
	public void test9() throws Exception {
		assertEquals(14, ParticipantObjectDataLifeCycle.LOGICAL_DELETION.getCode().intValue());
	}

	@Test
	public void test10() throws Exception {
		assertEquals(1, ParticipantObjectDataLifeCycle.ORIGINATION_OR_CREATION.getCode().intValue());
	}

	@Test
	public void test11() throws Exception {
		assertEquals(15, ParticipantObjectDataLifeCycle.PERMANENT_ERASURE_PHYSICAL_DESTRUCTION.getCode().intValue());
	}

	@Test
	public void test12() throws Exception {
		assertEquals(12, ParticipantObjectDataLifeCycle.RECEIPT_OF_DISCLOSURE.getCode().intValue());
	}

	@Test
	public void test13() throws Exception {
		assertEquals(9, ParticipantObjectDataLifeCycle.REPORT.getCode().intValue());
	}

	@Test
	public void test14() throws Exception {
		assertEquals(5, ParticipantObjectDataLifeCycle.TRANSLATION.getCode().intValue());
	}

	@Test
	public void test15() throws Exception {
		assertEquals(4, ParticipantObjectDataLifeCycle.VERIFICATION.getCode().intValue());
	}
}
