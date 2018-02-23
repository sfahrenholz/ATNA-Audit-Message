package com.sefah.atna.auditmessages.validator.factory;

import com.sefah.atna.auditmessages.validator.BeginTransferringDICOMInstancesValidator;
import com.sefah.atna.auditmessages.validator.DICOMInstancesAccessedValidator;
import com.sefah.atna.auditmessages.validator.DICOMInstancesTransferredValidator;
import com.sefah.atna.auditmessages.validator.DICOMStudyDeletedValidator;
import com.sefah.atna.auditmessages.validator.GetUserAuthenticationValidator;
import com.sefah.atna.auditmessages.validator.NetworkEntryValidator;
import com.sefah.atna.auditmessages.validator.OrderRecordValidator;
import com.sefah.atna.auditmessages.validator.PIXQueryValidator;
import com.sefah.atna.auditmessages.validator.base.Validator;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public enum ProfilValidator {

  GET_USER_AUTHENTICATION() {
    @Override
    final Validator getInstance() {
      return new GetUserAuthenticationValidator();
    }
  },
  PIX_QUERY() {
    @Override
    final Validator getInstance() {
      return new PIXQueryValidator();
    }
  },
  NETWORK_ENTRY() {
    @Override
    final Validator getInstance() {
      return new NetworkEntryValidator();
    }
  },
  ORDER_RECORD() {
    @Override
    final Validator getInstance() {
      return new OrderRecordValidator();
    }
  },
  DICOM_INSTANCE_ACCESSED() {
    @Override
    final Validator getInstance() {
      return new DICOMInstancesAccessedValidator();
    }
  },
  DICOM_INSTANCE_TRANSFERRED() {
    @Override
    final Validator getInstance() {
      return new DICOMInstancesTransferredValidator();
    }
  },
  BEGIN_TRANSFERRING_DCM_INSTANCES() {
    @Override
    final Validator getInstance() {
      return new BeginTransferringDICOMInstancesValidator();
    }
  },
  DICOM_STUDY_DELETED() {
    @Override
    final Validator getInstance() {
      return new DICOMStudyDeletedValidator();
    }
  };

  abstract Validator getInstance();
}
