package com.calculator.divideservice.service;

import com.calculator.divideservice.exceptions.FaultyRequestException;
import com.calculator.divideservice.exceptions.NumberMissingException;
import com.calculator.divideservice.model.request.OperationRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by akashdeepnew on 21/12/18.
 */
@Service
public class ValidationService {
    private static final Logger logger = LogManager.getLogger(ValidationService.class);

    public void validateServiceRequest(OperationRequest request) throws Exception {
        if (null == request) {
            throw new FaultyRequestException();
        }
        if (null == request.getFirstNumber()) {
            throw new NumberMissingException();
        }

        if (null == request.getSecondNumber()) {
            throw new NumberMissingException();
        }

        if (request.getSecondNumber().compareTo(new BigDecimal(0.0))==0) {
            throw new NumberMissingException();
        }
    }
}
