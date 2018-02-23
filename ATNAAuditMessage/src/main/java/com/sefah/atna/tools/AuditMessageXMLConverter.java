package com.sefah.atna.tools;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.sefah.atna.auditmessages.base.AuditMessage;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class AuditMessageXMLConverter {

  private final boolean prettyPrint;

  public AuditMessageXMLConverter(final boolean prettyPrint) {
    this.prettyPrint = prettyPrint;
  }

  public String convertXMLToString(final AuditMessage message) {
    final String result = "";
    try (ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
      final JAXBContext context = JAXBContext.newInstance(AuditMessage.class);
      final Marshaller marshaller = context.createMarshaller();
      marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, prettyPrint);
      marshaller.marshal(message, bout);
      return bout.toString();

    } catch (final Exception e) {
      e.printStackTrace(); // NOSONAR
    }
    return result;
  }

  public void writeXMLToFile(final String fileName, final AuditMessage message) {
    try (FileOutputStream fos = new FileOutputStream(fileName)) {
      fos.write(convertXMLToBytes(message));
    } catch (final Exception e) {
      // NOSONAR
    }

  }

  public byte[] convertXMLToBytes(final AuditMessage message) throws UnsupportedEncodingException {
    return convertXMLToString(message).getBytes("UTF-8");
  }
}
