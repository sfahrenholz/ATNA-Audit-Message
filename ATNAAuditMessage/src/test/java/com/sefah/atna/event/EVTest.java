package com.sefah.atna.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class EVTest {

	@Test
	public void testEV() throws Exception {
		final EV dummy = new EV(null, null, null);

		assertNull(dummy.getCode());
		assertNull(dummy.getCodeSystemName());
		assertNull(dummy.getOriginalText());
		assertNotNull(dummy.toString());

		dummy.setCode("Hallo");

		assertNotNull(dummy.getCode());
		assertEquals(dummy.getCode(), "Hallo");

		dummy.setCodeSystemName("IHE");
		assertNotNull(dummy.getCodeSystemName());
		assertEquals(dummy.getCodeSystemName(), "IHE");

		dummy.setOriginalText("Patient Record");
		assertNotNull(dummy.getOriginalText());
		assertEquals(dummy.getOriginalText(), "Patient Record");
		assertNotNull(dummy.toString());
	}

}
