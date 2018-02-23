package com.sefah.atna.tools;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.GetUserAuthentication;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.auditsourceidentification.AuditSourceIdentification;
import com.sefah.atna.codes.EventID;
import com.sefah.file.FileAccess;

public class AuditMessageXMLConverterTest {

	@ClassRule
	public static TemporaryFolder folder = new TemporaryFolder();

	@BeforeClass
	public static void beforeAll() throws IOException {
		folder.create();
	}

	@AfterClass
	public static void afterAll() {
		folder.delete();
	}

	@Test
	public void testConvertToXML() throws Exception {
		final String string = "2018-01-26T11:39:05.859+01:00";
		final DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final Date date = format.parse(string);

		final AuditMessage message = new GetUserAuthentication(EventID.DCM_110123);
		message.getEvent().setEventDateTime(date);
		message.addAuditSourceIdentification(new AuditSourceIdentification());
		message.addActiveParticipant(new ActiveParticipant());

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(message);
		assertNotNull(convertXMLToString);

		final String content = new String(
				FileAccess.getBytesOfPackageMessage("/com/sefah/atna/tools/ressource/message.xml"));
		assertEquals(content, convertXMLToString);
	}

	@Test
	public void testWriteAuditMessageToFile() throws Exception {
		final String string = "2018-01-26T11:39:05.859+01:00";
		final DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final Date date = format.parse(string);

		final AuditMessage message = new GetUserAuthentication(EventID.DCM_110123);
		message.getEvent().setEventDateTime(date);
		message.addAuditSourceIdentification(new AuditSourceIdentification());
		message.addActiveParticipant(new ActiveParticipant());

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final File newFile = folder.newFile("File.xml");
		conv.writeXMLToFile(newFile.getAbsolutePath(), message);

		final String fileContent = new String(FileAccess.getBytesOfMessage(newFile.getAbsolutePath()));
		final String content = new String(
				FileAccess.getBytesOfPackageMessage("/com/sefah/atna/tools/ressource/message.xml"));
		assertEquals(content, fileContent);
	}
}
