package com.sefah.atna.auditmessages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.auditmessages.validator.base.Validator;
import com.sefah.atna.auditmessages.validator.factory.ValidatorFactory;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.tools.AuditMessageXMLConverter;
import com.sefah.file.FileAccess;

public class NetworkEntryTest {

	@Test
	public void testCreatingDefaultmessageAttach() throws Exception {
		final AuditMessage auditMessage = new NetworkEntry(EventID.DCM_110124);
		auditMessage.getEvent().setEventDateTime(getDateStringForTest());
		final ActiveParticipant person = new ActiveParticipant();
		person.setUserID("123456");
		person.setUserIsRequestor(Boolean.FALSE);

		auditMessage.addActiveParticipant(person);

		final Validator instance = ValidatorFactory.getInstance(EventID.DCM_110108);
		assertTrue(instance.validate(auditMessage));

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(auditMessage);

		final String content = new String(FileAccess
				.getBytesOfPackageMessage("/com/sefah/atna/auditmessages/ressource/messageNetworkEntryAttach.xml"));
		assertEquals(content, convertXMLToString);
	}

	@Test
	public void testCreatingDefaultmessageDetach() throws Exception {
		final AuditMessage auditMessage = new NetworkEntry(EventID.DCM_110125);
		auditMessage.getEvent().setEventDateTime(getDateStringForTest());
		final ActiveParticipant person = new ActiveParticipant();
		person.setUserID("123456");
		person.setUserIsRequestor(Boolean.FALSE);

		auditMessage.addActiveParticipant(person);

		final Validator instance = ValidatorFactory.getInstance(EventID.DCM_110108);
		assertTrue(instance.validate(auditMessage));

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(auditMessage);

		final String content = new String(FileAccess
				.getBytesOfPackageMessage("/com/sefah/atna/auditmessages/ressource/messageNetworkEntryDetach.xml"));
		assertEquals(content, convertXMLToString);
	}

	private Date getDateStringForTest() throws ParseException {
		final String string = "2018-01-27T11:18:13.656+01:00";
		final DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final Date date = format.parse(string);
		return date;
	}
}
