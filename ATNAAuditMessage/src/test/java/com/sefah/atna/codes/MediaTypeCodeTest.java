package com.sefah.atna.codes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MediaTypeCodeTest {

	@Test
	public void testCD() throws Exception {
		assertEquals("110032", MediaTypeCode.CD.getCode().getCode());
	}

	@Test
	public void testUSB() throws Exception {
		assertEquals("110030", MediaTypeCode.USB.getCode().getCode());
	}

	@Test
	public void testEMail() throws Exception {
		assertEquals("110031", MediaTypeCode.EMAIL.getCode().getCode());
	}

	@Test
	public void testDVD() throws Exception {
		assertEquals("110033", MediaTypeCode.DVD.getCode().getCode());
	}

	@Test
	public void testCompactFlash() throws Exception {
		assertEquals("110034", MediaTypeCode.COMPACT_FLASH.getCode().getCode());
	}

	@Test
	public void testMMC() throws Exception {
		assertEquals("110035", MediaTypeCode.MMC.getCode().getCode());
	}

	@Test
	public void testSD() throws Exception {
		assertEquals("110036", MediaTypeCode.SD.getCode().getCode());
	}

	@Test
	public void testURI() throws Exception {
		assertEquals("110037", MediaTypeCode.URI.getCode().getCode());
	}

	@Test
	public void testFilm() throws Exception {
		assertEquals("110038", MediaTypeCode.FILM.getCode().getCode());
	}

	@Test
	public void testPaperDocument() throws Exception {
		assertEquals("110039", MediaTypeCode.PAPER_DOCUMENT.getCode().getCode());
	}
}
