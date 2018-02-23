package com.sefah.atna.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class ValidatorExceptionTest {

	@Test
	public void testValidatorExceptionWithoutValue() throws Exception {
		final ValidatorException exception = new ValidatorException(ValidatorErrorCode.ATNA_DEFAULT);

		assertNull(exception.getCause());
		assertNotNull(exception.getStackTrace());
		assertNotNull(exception.getError());
		assertEquals(ValidatorErrorCode.ATNA_DEFAULT.getCode(), exception.getErrorCode());
		assertEquals(ValidatorErrorCode.ATNA_DEFAULT.getDescription(), exception.getErrorMsg());
	}

	@Test
	public void testValidatorException() throws Exception {
		final ValidatorException exception = new ValidatorException(ValidatorErrorCode.ATNA_VALIDATOR_FACTORY, "Hallo");

		assertNull(exception.getCause());
		assertNotNull(exception.getStackTrace());
		assertNotNull(exception.getError());
		assertEquals(ValidatorErrorCode.ATNA_VALIDATOR_FACTORY.getCode(), exception.getErrorCode());
		assertEquals("For the message event Hallo, there is no validator.", exception.getErrorMsg());
	}
}
