package com.sefah.atna.auditmessages;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.Test;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.codes.MediaTypeCode;
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
public class DataExportTest {
	@Test
	public void testAuditMessageDataExport() throws Exception {

		final ActiveParticipant userAP = new ActiveParticipant();
		userAP.setUserID("123456");
		userAP.setRoleIDCode(EventID.DCM_110152);
		userAP.setUserIsRequestor(Boolean.TRUE);

		final ActiveParticipant media = new ActiveParticipant();
		media.setUserID("123456");
		media.setRoleIDCode(EventID.DCM_110154);
		media.setUserIsRequestor(Boolean.FALSE);
		media.setMediaType(MediaTypeCode.URI.getCode());
		media.setMediaIdentifier(
				"Volume ID, URI, or other identifier for media.  Required if digital media. May be present otherwise.");

		final ParticipantObjectIdentification study = new ParticipantObjectIdentification();
		study.setParticipantObjectTypeCode(ParticipantObjectTypeCode.SYSTEM.getCode());
		study.setParticipantObjectTypeCodeRole(ParticipantObjectTypeCodeRole.REPORT.getActionCode());
		study.setParticipantObjectIDTypeCode(EventID.DCM_110180);
		study.setParticipantObjectID("The Study Instance UID");
		study.setSopClass(Arrays.asList("1.2", "1.3"));

		final ParticipantObjectIdentification patient = new ParticipantObjectIdentification();
		patient.setParticipantObjectTypeCode(ParticipantObjectTypeCode.PERSON.getCode());
		patient.setParticipantObjectTypeCodeRole(ParticipantObjectTypeCodeRole.PATIENT.getActionCode());
		patient.setParticipantObjectIDTypeCode(ParticipantObjectIDTypeCode.PATIENT_ID.getCode());
		patient.setParticipantObjectID("The patient ID");
		patient.setParticipantObjectName("Patients Name");

		final AuditMessage messageStart = new DataExport();
		messageStart.addActiveParticipant(userAP);
		messageStart.addActiveParticipant(media);
		messageStart.addParticipantObjectIdentification(patient);
		messageStart.addParticipantObjectIdentification(study);
		messageStart.getEvent().setEventDateTime(getDateStringForTest());

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(messageStart);

		final String content = new String(FileAccess
				.getBytesOfPackageMessage("/com/sefah/atna/auditmessages/ressource/messageAuditMessageDataExport.xml"));
		assertEquals(content, convertXMLToString);
	}

	private Date getDateStringForTest() throws ParseException {
		final String string = "2018-01-27T11:18:13.656+01:00";
		final DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final Date date = format.parse(string);
		return date;
	}
}
