/**
 *
 */
package com.sefah.atna.auditmessages.validator.base;

/**
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class CountOfObjects {
  private boolean hasUserRequestor;
  private int dcm110153;
  private int dcm110152;
  private int dcm110180;
  private int patient;
  private int otherParticipantObjectIdentification;
  private int otherActiveParticipant;

  public CountOfObjects() {
    hasUserRequestor = false;
    dcm110153 = 0;
    dcm110152 = 0;
    dcm110180 = 0;
    patient = 0;
    otherParticipantObjectIdentification = 0;
    otherActiveParticipant = 0;
  }

  public boolean isHasUserRequestor() {
    return hasUserRequestor;
  }

  public int getDcm110153() {
    return dcm110153;
  }

  public int getDcm110152() {
    return dcm110152;
  }

  public int getDcm110180() {
    return dcm110180;
  }

  public int getPatient() {
    return patient;
  }

  public int getOtherParticipantObjectIdentification() {
    return otherParticipantObjectIdentification;
  }

  public int getOtherActiveParticipant() {
    return otherActiveParticipant;
  }

  public void hasUserRequestor() {
    hasUserRequestor = true;
  }

  public void increasedcm110153() {
    ++dcm110153;
  }

  public void increasedcm110152() {
    ++dcm110152;
  }

  public void increasedcm110180() {
    ++dcm110180;
  }

  public void increasedPatient() {
    ++patient;
  }

  public void increasedOtherActiveParticipant() {
    ++otherActiveParticipant;
  }

  public void increasedOtherParticipantObjectIdentification() {
    ++otherParticipantObjectIdentification;
  }
}
