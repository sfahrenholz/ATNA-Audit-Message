package com.sefah.atna.auditmessages.validator.factory;

import java.util.HashMap;
import java.util.Map;

import com.sefah.atna.auditmessages.validator.base.Validator;
import com.sefah.atna.codes.EventID;
import com.sefah.atna.event.EV;
import com.sefah.atna.exceptions.ValidatorErrorCode;
import com.sefah.atna.exceptions.ValidatorException;

/**
 *
 * @author fahrenholz
 *
 *         (c) 2018 - Alle Rechte vorbehalten
 *
 */
public class ValidatorFactory {

  private static final Map<EV, ProfilValidator> repairMap;

  static {
    repairMap = new HashMap<>();
    repairMap.put(EventID.DCM_110102, ProfilValidator.BEGIN_TRANSFERRING_DCM_INSTANCES);
    repairMap.put(EventID.DCM_110103, ProfilValidator.DICOM_INSTANCE_ACCESSED);
    repairMap.put(EventID.DCM_110104, ProfilValidator.DICOM_INSTANCE_TRANSFERRED);
    repairMap.put(EventID.DCM_110105, ProfilValidator.DICOM_STUDY_DELETED);
    repairMap.put(EventID.DCM_110108, ProfilValidator.NETWORK_ENTRY);
    repairMap.put(EventID.DCM_110109, ProfilValidator.ORDER_RECORD);

    repairMap.put(EventID.DCM_110112, ProfilValidator.PIX_QUERY);
    repairMap.put(EventID.DCM_110114, ProfilValidator.GET_USER_AUTHENTICATION);
  }

  private ValidatorFactory() {
    // SQ
  }

  public static Validator getInstance(final EV code) throws ValidatorException {
    final ProfilValidator type = repairMap.get(code);
    if (type != null) {
      return type.getInstance();
    }

    throw new ValidatorException(ValidatorErrorCode.ATNA_VALIDATOR_FACTORY, code);
  }
}
