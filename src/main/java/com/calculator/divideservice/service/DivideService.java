package com.calculator.divideservice.service;

import com.calculator.divideservice.model.request.OperationRequest;
import com.calculator.divideservice.model.response.OperationResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by akashdeepnew on 20/12/18.
 */
@Service
public class DivideService {

    @Autowired
    private PropertyProviderService propertyProviderService;

    public OperationResultResponse divide(OperationRequest request) {
        BigDecimal result = divide(request.getFirstNumber(),request.getSecondNumber());
        return new OperationResultResponse(result,getCreditCost());
    }

    private BigDecimal divide(BigDecimal first, BigDecimal second) {
        return first.divide(second);
    }

    public Double getCreditCost() {
        return propertyProviderService.getCreditCost();
    }

}
