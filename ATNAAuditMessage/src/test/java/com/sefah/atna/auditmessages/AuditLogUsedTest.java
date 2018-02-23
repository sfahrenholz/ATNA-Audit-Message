package com.sefah.atna.auditmessages;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.ParticipantObjectIDTypeCode;
import com.sefah.atna.codes.ParticipantObjectTypeCode;
import com.sefah.atna.codes.ParticipantObjectTypeCodeRole;
import com.sefah.atna.participantobjectidentification.ParticipantObjectIdentification;
import com.sefah.atna.tools.AuditMessageXMLConverter;
import com.sefah.file.FileAccess;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class AuditLogUsedTest {

	@Test
	public void testAuditLogUsedMessage() throws Exception {

		final ActiveParticipant userAP = new ActiveParticipant();
		userAP.setUserID("123456");
		userAP.setUserIsRequestor(Boolean.TRUE);

		final ParticipantObjectIdentification patient = new ParticipantObjectIdentification();
		patient.setParticipantObjectTypeCode(ParticipantObjectTypeCode.SYSTEM.getCode());
		patient.setParticipantObjectTypeCodeRole(ParticipantObjectTypeCodeRole.SECURITY_RESOURCE.getActionCode());
		patient.setParticipantObjectIDTypeCode(ParticipantObjectIDTypeCode.URI.getCode());
		patient.setParticipantObjectID("The URI of the audit log");
		patient.setParticipantObjectName("Shall be: \"Security Audit Log\"");

		final AuditMessage messageStart = new AuditLogUsed();
		messageStart.addActiveParticipant(userAP);
		messageStart.addParticipantObjectIdentification(patient);
		messageStart.getEvent().setEventDateTime(getDateStringForTest());

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(messageStart);

		final String content = new String(
				FileAccess.getBytesOfPackageMessage("/com/sefah/atna/auditmessages/ressource/messageAuditLogUsed.xml"));
		assertEquals(content, convertXMLToString);
	}

	private Date getDateStringForTest() throws ParseException {
		final String string = "2018-01-27T11:18:13.656+01:00";
		final DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final Date date = format.parse(string);
		return date;
	}
}
