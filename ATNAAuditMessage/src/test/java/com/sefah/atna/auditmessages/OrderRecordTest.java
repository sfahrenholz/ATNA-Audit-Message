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
import com.sefah.atna.codes.EventActionCodes;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.codes.ParticipantObjectIDTypeCode;
import com.sefah.atna.codes.ParticipantObjectTypeCode;
import com.sefah.atna.codes.ParticipantObjectTypeCodeRole;
import com.sefah.atna.participantobjectidentification.ParticipantObjectIdentification;
import com.sefah.atna.tools.AuditMessageXMLConverter;
import com.sefah.file.FileAccess;

public class OrderRecordTest {

	@Test
	public void testCreatingDefaultmessageCreate() throws Exception {
		final AuditMessage auditMessage = new OrderRecord();
		auditMessage.getEvent().setEventActionCode(EventActionCodes.CREATE);
		auditMessage.getEvent().setEventDateTime(getDateStringForTest());

		final ActiveParticipant user1 = new ActiveParticipant();
		user1.setUserID("123456");
		// final ActiveParticipant user2 = new ActiveParticipant();
		// user2.setUserID("123456");
		// user2.setUserIsRequestor(Boolean.FALSE);

		final ParticipantObjectIdentification patient = new ParticipantObjectIdentification();
		patient.setParticipantObjectTypeCode(ParticipantObjectTypeCode.PERSON.getCode());
		patient.setParticipantObjectTypeCodeRole(ParticipantObjectTypeCodeRole.PATIENT.getActionCode());
		patient.setParticipantObjectIDTypeCode(ParticipantObjectIDTypeCode.PATIENT_ID.getCode());
		patient.setParticipantObjectID("The patient ID");

		auditMessage.addActiveParticipant(user1);
		auditMessage.addParticipantObjectIdentification(patient);

		final Validator instance = ValidatorFactory.getInstance(EventID.DCM_110109);
		assertTrue(instance.validate(auditMessage));

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(auditMessage);

		final String content = new String(FileAccess
				.getBytesOfPackageMessage("/com/sefah/atna/auditmessages/ressource/messageOrderRecordCreate.xml"));
		assertEquals(content, convertXMLToString);
	}

	private Date getDateStringForTest() throws ParseException {
		final String string = "2018-01-27T11:18:13.656+01:00";
		final DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final Date date = format.parse(string);
		return date;
	}
}
