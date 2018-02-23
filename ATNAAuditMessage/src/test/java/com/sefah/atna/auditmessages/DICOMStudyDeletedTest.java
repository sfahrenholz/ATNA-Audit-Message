package com.sefah.atna.auditmessages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.auditmessages.validator.base.Validator;
import com.sefah.atna.auditmessages.validator.factory.ValidatorFactory;
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.codes.ParticipantObjectIDTypeCode;
import com.sefah.atna.codes.ParticipantObjectTypeCode;
import com.sefah.atna.codes.ParticipantObjectTypeCodeRole;
import com.sefah.atna.exceptions.ValidatorException;
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
public class DICOMStudyDeletedTest {
	private static Validator validator;

	@BeforeClass
	public static void beforeAll() throws ValidatorException {
		validator = ValidatorFactory.getInstance(EventID.DCM_110105);
	}

	@Test
	public void testDICOMInstancesAccessedCreate() throws Exception {

		final ActiveParticipant person = new ActiveParticipant();
		person.setUserID("123456");
		person.setUserIsRequestor(Boolean.TRUE);

		final ActiveParticipant processed = new ActiveParticipant();
		processed.setUserID("123456");
		processed.setUserIsRequestor(Boolean.FALSE);

		// 1.. N
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

		final AuditMessage messageStart = new DICOMStudyDeleted();
		messageStart.getEvent().setEventActionCode(EventActionCodes.CREATE);
		messageStart.addActiveParticipant(person);
		messageStart.addActiveParticipant(processed);
		messageStart.addParticipantObjectIdentification(study);
		messageStart.addParticipantObjectIdentification(patient);
		messageStart.getEvent().setEventDateTime(getDateStringForTest());

		assertTrue(validator.validate(messageStart));

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(messageStart);

		final String content = new String(FileAccess
				.getBytesOfPackageMessage("/com/sefah/atna/auditmessages/ressource/messageDICOMStudyDeleted.xml"));
		assertEquals(content, convertXMLToString);
	}

	private Date getDateStringForTest() throws ParseException {
		final String string = "2018-01-27T11:18:13.656+01:00";
		final DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final Date date = format.parse(string);
		return date;
	}
}
