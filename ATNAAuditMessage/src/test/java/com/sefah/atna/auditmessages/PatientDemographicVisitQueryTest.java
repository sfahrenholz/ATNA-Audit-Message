package com.sefah.atna.auditmessages;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.sefah.atna.activeparticipant.ActiveParticipant;
import com.sefah.atna.auditmessages.base.AuditMessage;
import com.sefah.atna.auditsourceidentification.AuditSourceIdentification;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.codes.NetworkAccessPointTypeCode;
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
public class PatientDemographicVisitQueryTest {

	@Test
	public void testPatientDemographicsConsumerAuditMessage() throws Exception {
		final ActiveParticipant source = new ActiveParticipant();
		source.setUserID("123456");
		source.setAlternativeUserID("123456");
		source.setRoleIDCode(EventID.DCM_110153);
		source.setNetworkAccessPointID("127.0.0.1");
		source.setNetworkAccessPointTypeCode(NetworkAccessPointTypeCode.IP_ADDRESS);

		final ActiveParticipant human = new ActiveParticipant();
		human.setUserID("123456");

		final ActiveParticipant destination = new ActiveParticipant();
		destination.setUserID("123456");
		destination.setRoleIDCode(EventID.DCM_110152);
		destination.setNetworkAccessPointID("127.0.0.1");
		destination.setNetworkAccessPointTypeCode(NetworkAccessPointTypeCode.IP_ADDRESS);

		final AuditSourceIdentification auditSource = new AuditSourceIdentification();

		final ParticipantObjectIdentification patient = new ParticipantObjectIdentification();
		patient.setParticipantObjectTypeCode(ParticipantObjectTypeCode.PERSON.getCode());
		patient.setParticipantObjectTypeCodeRole(ParticipantObjectTypeCodeRole.PATIENT.getActionCode());
		patient.setParticipantObjectID("patientsID");

		final ParticipantObjectIdentification query = new ParticipantObjectIdentification();
		query.setParticipantObjectTypeCode(ParticipantObjectTypeCode.SYSTEM_OBJECT.getCode());
		query.setParticipantObjectIDTypeCode(EventID.ITI_22);
		query.setParticipantObjectTypeCodeRole(ParticipantObjectTypeCodeRole.QUERY.getActionCode());
		query.setParticipantObjectQuery("QPD segment");
		query.setParticipantObjectDetail("participantObjectDetail");

		final AuditMessage messageStart = new PatientDemographicVisitQuery();
		messageStart.addActiveParticipant(source);
		messageStart.addActiveParticipant(human);
		messageStart.addActiveParticipant(destination);
		messageStart.addAuditSourceIdentification(auditSource);
		messageStart.addParticipantObjectIdentification(patient);
		messageStart.addParticipantObjectIdentification(query);
		messageStart.getEvent().setEventDateTime(getDateStringForTest());

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(messageStart);

		final String content = new String(FileAccess.getBytesOfPackageMessage(
				"/com/sefah/atna/auditmessages/ressource/messagePatientDemographicVisitQueryConsumer.xml"));
		assertEquals(content, convertXMLToString);
	}

	@Test
	public void testPatientDemographicsSourceAuditMessage() throws Exception {
		final ActiveParticipant source = new ActiveParticipant();
		source.setUserID("123456");
		source.setAlternativeUserID("123456");
		source.setRoleIDCode(EventID.DCM_110153);
		source.setNetworkAccessPointID("127.0.0.1");
		source.setNetworkAccessPointTypeCode(NetworkAccessPointTypeCode.IP_ADDRESS);

		final ActiveParticipant destination = new ActiveParticipant();
		destination.setUserID("123456");
		destination.setRoleIDCode(EventID.DCM_110152);
		destination.setNetworkAccessPointID("127.0.0.1");
		destination.setNetworkAccessPointTypeCode(NetworkAccessPointTypeCode.IP_ADDRESS);

		final AuditSourceIdentification auditSource = new AuditSourceIdentification();

		final ParticipantObjectIdentification patient = new ParticipantObjectIdentification();
		patient.setParticipantObjectTypeCode(ParticipantObjectTypeCode.PERSON.getCode());
		patient.setParticipantObjectTypeCodeRole(ParticipantObjectTypeCodeRole.PATIENT.getActionCode());
		patient.setParticipantObjectID("patientsID");

		final ParticipantObjectIdentification query = new ParticipantObjectIdentification();
		query.setParticipantObjectTypeCode(ParticipantObjectTypeCode.SYSTEM_OBJECT.getCode());
		query.setParticipantObjectIDTypeCode(EventID.ITI_22);
		query.setParticipantObjectTypeCodeRole(ParticipantObjectTypeCodeRole.QUERY.getActionCode());
		query.setParticipantObjectQuery("QPD segment");
		query.setParticipantObjectDetail("participantObjectDetail");

		final AuditMessage messageStart = new PatientDemographicVisitQuery();
		messageStart.addActiveParticipant(source);
		messageStart.addActiveParticipant(destination);
		messageStart.addAuditSourceIdentification(auditSource);
		messageStart.addParticipantObjectIdentification(patient);
		messageStart.addParticipantObjectIdentification(query);
		messageStart.getEvent().setEventDateTime(getDateStringForTest());

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(messageStart);

		final String content = new String(FileAccess.getBytesOfPackageMessage(
				"/com/sefah/atna/auditmessages/ressource/messagePatientDemographicVisitQuerySource.xml"));
		assertEquals(content, convertXMLToString);
	}

	private Date getDateStringForTest() throws ParseException {
		final String string = "2018-01-27T11:18:13.656+01:00";
		final DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final Date date = format.parse(string);
		return date;
	}
}
