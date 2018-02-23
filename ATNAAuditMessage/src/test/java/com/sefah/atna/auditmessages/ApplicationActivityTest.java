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
import com.sefah.atna.tools.AuditMessageXMLConverter;
import com.sefah.file.FileAccess;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class ApplicationActivityTest {

	@Test
	public void testCreatingDefaultmessage() throws Exception {
		final ApplicationActivity auditMessage = new ApplicationActivity(EventID.DCM_110120);

		assertEquals(auditMessage.getEvent().getEventID(), EventID.DCM_110100);
		assertEquals(auditMessage.getEvent().getEventTypeCode(), EventID.DCM_110120);
	}

	@Test
	public void testDCM_APPLICATION_START_110120() throws Exception {
		final ActiveParticipant userAP = new ActiveParticipant();
		userAP.setUserID("123456");
		userAP.setAlternativeUserID("123456");
		userAP.setRoleIDCode(EventID.DCM_110150);
		userAP.setNetworkAccessPointID("127.0.0.1");
		userAP.setNetworkAccessPointTypeCode(NetworkAccessPointTypeCode.IP_ADDRESS);
		userAP.setUserIsRequestor(Boolean.FALSE);

		final AuditSourceIdentification auditSource = new AuditSourceIdentification();
		auditSource.setAuditSourceID("SEF@AuditMessage");

		final AuditMessage messageStart = new ApplicationActivity(EventID.DCM_110120);
		messageStart.addActiveParticipant(userAP);
		messageStart.addAuditSourceIdentification(auditSource);
		messageStart.getEvent().setEventDateTime(getDateStringForTest());

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(messageStart);

		final String content = new String(FileAccess
				.getBytesOfPackageMessage("/com/sefah/atna/auditmessages/ressource/messageApplicationStart.xml"));
		assertEquals(content, convertXMLToString);
	}

	@Test
	public void testDCM_APPLICATION_STOP_110121() throws Exception {
		final ActiveParticipant userAP = new ActiveParticipant();
		userAP.setUserID("123456");
		userAP.setAlternativeUserID("123456");
		userAP.setRoleIDCode(EventID.DCM_110150);
		userAP.setNetworkAccessPointID("127.0.0.1");
		userAP.setNetworkAccessPointTypeCode(NetworkAccessPointTypeCode.IP_ADDRESS);
		userAP.setUserIsRequestor(Boolean.FALSE);

		final AuditSourceIdentification auditSource = new AuditSourceIdentification();
		auditSource.setAuditSourceID("SEF@AuditMessage");

		final AuditMessage messageStop = new ApplicationActivity(EventID.DCM_110121);
		messageStop.addActiveParticipant(userAP);
		messageStop.addAuditSourceIdentification(auditSource);
		messageStop.getEvent().setEventDateTime(getDateStringForTest());

		final AuditMessageXMLConverter conv = new AuditMessageXMLConverter(true);
		final String convertXMLToString = conv.convertXMLToString(messageStop);

		final String content = new String(FileAccess
				.getBytesOfPackageMessage("/com/sefah/atna/auditmessages/ressource/messageApplicationStop.xml"));
		assertEquals(content, convertXMLToString);
	}

	private Date getDateStringForTest() throws ParseException {
		final String string = "2018-01-27T11:18:13.656+01:00";
		final DateFormat format = new SimpleDateFormat("yyy-MM-dd'T'HH:mm:ss.SSSXXX");
		final Date date = format.parse(string);
		return date;
	}
}
