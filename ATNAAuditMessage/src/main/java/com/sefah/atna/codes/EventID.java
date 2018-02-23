package com.sefah.atna.codes;

import com.sefah.atna.event.EV;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class EventID {

  private static final String IHE_TRANSACTIONS = "IHE Transactions";
  private static final String DCM = "DCM";
  private static final String IHE_XDS_METADATA = "IHE XDS Metadata";

  private EventID() {
    // SQ
  }

  public static final EV IHE_XDS_CLASSIFICATION_NODE = new EV(
      "urn:uuid:a54d6aa5-d40d-43f9-88c5-b4633d873bdd", IHE_XDS_METADATA,
      "submission set classificationNode");
  public static final EV IHE_XDS_ENTRY_TYPE = new EV(
      "urn:uuid:7edca82f-054d-47f2-a032-9b2a5b5186c1", IHE_XDS_METADATA,
      "document entry object type");
  public static final EV IHE_XDS_ON_DEMAND_ENTRY_TYPE = new EV(
      "urn:uuid:34268e47-fdf5-41a6-ba33-82133c465248", IHE_XDS_METADATA,
      "on-demand document entry object type");
  public static final EV IHE_XDS_REGISTRY_OBJ_REFERENCE = new EV("urn:ihe:iti:2017:ObjectRef",
      IHE_XDS_METADATA, "registry object reference");

  public static final EV DCM_110100 = new EV("110100", DCM, "Application Activity");
  public static final EV DCM_110101 = new EV("110101", DCM, "Audit Log Used");
  public static final EV DCM_110102 = new EV("110102", DCM, "Begin Transferring DICOM Instances");
  public static final EV DCM_110103 = new EV("110103", DCM, "DICOM Instances Accessed");
  public static final EV DCM_110104 = new EV("110104", DCM, "DICOM Instances Transferred");
  public static final EV DCM_110105 = new EV("110105", DCM, "DICOM Study Deleted");
  public static final EV DCM_110106 = new EV("110106", DCM, "Export");
  public static final EV DCM_110107 = new EV("110107", DCM, "Import");
  public static final EV DCM_110108 = new EV("110108", DCM, "Network Entry");
  public static final EV DCM_110109 = new EV("110109", DCM, "Order Record");

  public static final EV DCM_110110 = new EV("110110", DCM, "Patient Record");
  public static final EV DCM_110111 = new EV("110111", DCM, "Procedure Record");
  public static final EV DCM_110112 = new EV("110112", DCM, "Query");
  public static final EV DCM_110113 = new EV("110113", DCM, "Security Alert");
  public static final EV DCM_110114 = new EV("110114", DCM, "User Authentication");

  public static final EV DCM_110120 = new EV("110120", DCM, "Application Start");
  public static final EV DCM_110121 = new EV("110121", DCM, "Application Stop");
  public static final EV DCM_110122 = new EV("110122", DCM, "Login");
  public static final EV DCM_110123 = new EV("110123", DCM, "Logout");
  public static final EV DCM_110124 = new EV("110124", DCM, "Attach");
  public static final EV DCM_110125 = new EV("110125", DCM, "Detach");
  public static final EV DCM_110126 = new EV("110126", DCM, "Node Authentication");
  public static final EV DCM_110127 = new EV("110127", DCM, "Emergency Override Started");
  public static final EV DCM_110128 = new EV("110128", DCM, "Network Configuration");
  public static final EV DCM_110129 = new EV("110129", DCM, "Security Configuration");

  public static final EV DCM_110130 = new EV("110130", DCM, "Hardware Configuration");
  public static final EV DCM_110131 = new EV("110131", DCM, "Software Configuration");
  public static final EV DCM_110132 = new EV("110132", DCM, "Use of Restricted Function");
  public static final EV DCM_110133 = new EV("110133", DCM, "Audit Recording Stopped");
  public static final EV DCM_110134 = new EV("110134", DCM, "Audit Recording Started");
  public static final EV DCM_110135 = new EV("110135", DCM, "Object Security Attributes Changed");
  public static final EV DCM_110136 = new EV("110136", DCM, "Security Roles Changed");
  public static final EV DCM_110137 = new EV("110137", DCM, "User Security Attributes Changed");
  public static final EV DCM_110138 = new EV("110138", DCM, "Emergency Override Stopped");
  public static final EV DCM_110139 = new EV("110139", DCM, "Remote Service Operation Started");

  public static final EV DCM_110140 = new EV("110140", DCM, "Remote Service Operation Stopped");
  public static final EV DCM_110141 = new EV("110141", DCM, "Local Service Operation Started");
  public static final EV DCM_110142 = new EV("110142", DCM, "Local Service Operation Stopped");
  public static final EV DCM_110143 = new EV("110143", DCM, "Authentication Decision");
  public static final EV DCM_110144 = new EV("110144", DCM, "Authorization Decision");
  public static final EV DCM_110145 = new EV("110145", DCM, "Session start");
  public static final EV DCM_110146 = new EV("110146", DCM, "Session stop");
  public static final EV DCM_110147 = new EV("110147", DCM, "Access Control Decision");

  public static final EV DCM_110150 = new EV("110150", DCM, "Application");
  public static final EV DCM_110151 = new EV("110151", DCM, "Application Launcher");
  public static final EV DCM_110152 = new EV("110152", DCM, "Destination");
  public static final EV DCM_110153 = new EV("110153", DCM, "Source");
  public static final EV DCM_110154 = new EV("110154", DCM, "Destination Media");
  public static final EV DCM_110155 = new EV("110155", DCM, "Source Media");

  public static final EV DCM_110180 = new EV("110180", DCM, "Study Instance UID");
  public static final EV DCM_110181 = new EV("110181", DCM, "SOP Class UID");
  public static final EV DCM_110182 = new EV("110182", DCM, "Node ID");

  public static final EV ITI_8 = new EV("ITI-8", IHE_TRANSACTIONS, "Patient Identity Feed");
  public static final EV ITI_9 = new EV("ITI-9", IHE_TRANSACTIONS, "PIX Query");

  public static final EV ITI_10 = new EV("ITI-10", IHE_TRANSACTIONS, "PIX Update Notification");
  public static final EV ITI_14 = new EV("ITI-14", IHE_TRANSACTIONS, "Register Document Set");
  public static final EV ITI_15 = new EV("ITI-15", IHE_TRANSACTIONS,
      "Provide and Register Document Set");
  public static final EV ITI_16 = new EV("ITI-16", IHE_TRANSACTIONS, "Registry SQL Query");
  public static final EV ITI_17 = new EV("ITI-17", IHE_TRANSACTIONS, "Retrieve Document");
  public static final EV ITI_18 = new EV("ITI-21", IHE_TRANSACTIONS, "Registry Stored Query");

  public static final EV ITI_21 = new EV("ITI-21", IHE_TRANSACTIONS, "Patient Demographics Query");
  public static final EV ITI_22 = new EV("ITI-22", IHE_TRANSACTIONS,
      "Patient Demographics and Visit Query");

  public static final EV ITI_30 = new EV("ITI-30", IHE_TRANSACTIONS, "Patient Identity Management");
  public static final EV ITI_32 = new EV("ITI-32", IHE_TRANSACTIONS,
      "Distribute Document Set on Media");
  public static final EV ITI_38 = new EV("ITI-38", IHE_TRANSACTIONS, "Cross Gateway Query");
  public static final EV ITI_39 = new EV("ITI-39", IHE_TRANSACTIONS, "Cross Gateway Retrieve");

  public static final EV ITI_41 = new EV("ITI-41", IHE_TRANSACTIONS,
      "Provide and Register Document Set-b");
  public static final EV ITI_42 = new EV("ITI-42", IHE_TRANSACTIONS, "Register Document Set-b");
  public static final EV ITI_43 = new EV("ITI-43", IHE_TRANSACTIONS, "Retrieve Document Set");
  public static final EV ITI_44 = new EV("ITI-44", IHE_TRANSACTIONS, "Patient Identity Feed");
  public static final EV ITI_45 = new EV("ITI-45", IHE_TRANSACTIONS, "PIX Query");
  public static final EV ITI_46 = new EV("ITI-46", IHE_TRANSACTIONS, "PIX Update Notification");
  public static final EV ITI_47 = new EV("ITI-47", IHE_TRANSACTIONS, "Patient Demographics Query");
  public static final EV ITI_48 = new EV("ITI-48", IHE_TRANSACTIONS, "Retrieve Value Sets");

  public static final EV ITI_51 = new EV("ITI-51", IHE_TRANSACTIONS, "Multi-Patient Stored Query");
  public static final EV ITI_52 = new EV("ITI-52", IHE_TRANSACTIONS, "Document Metadata Subscribe");
  public static final EV ITI_53 = new EV("ITI-53", IHE_TRANSACTIONS, "Document Metadata Notify");
  public static final EV ITI_54 = new EV("ITI-54", IHE_TRANSACTIONS, "Document Metadata Publish");
  public static final EV ITI_55 = new EV("ITI-55", IHE_TRANSACTIONS,
      "Cross Gateway Patient Discovery");

  public static final EV ITI_60 = new EV("ITI-60", IHE_TRANSACTIONS,
      "Retrieve Multiple Value Sets");
  public static final EV ITI_61 = new EV("ITI-61", IHE_TRANSACTIONS,
      "Register On-Demand Document Entry");
}
