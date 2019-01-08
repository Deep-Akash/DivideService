package com.calculator.divideservice.controller;

import com.calculator.divideservice.enums.APIResponseCodeENUM;
import com.calculator.divideservice.exceptions.APIBaseException;
import com.calculator.divideservice.model.request.OperationRequest;
import com.calculator.divideservice.model.response.APIResponse;
import com.calculator.divideservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

/**
 * Created by akashdeepnew on 20/12/18.
 */
@RestController
@RequestMapping(value = "/divide")
public class DivideOperationController {

    @Autowired
    private DivideService divideService;

    @Autowired
    private ValidationService validateService;


    @PostMapping("/calculate")
    @ResponseBody
    public APIResponse calculate(@RequestBody OperationRequest operationRequest) throws Exception {
        validateService.validateServiceRequest(operationRequest);
        return APIResponse.buildSuccess(divideService.divide(operationRequest));
    }

    @GetMapping("/cost")
    @ResponseBody
    public APIResponse creditCost() throws Exception {
        return APIResponse.buildSuccess(divideService.getCreditCost());
    }


    @ExceptionHandler
    @ResponseBody
    public APIResponse handleException(Exception ex) {
        if (ex instanceof APIBaseException){
            return APIResponse.buildFailure(((APIBaseException) ex).getApiResponseCodeENUM());
        }
        return APIResponse.buildFailure(APIResponseCodeENUM.GENERAL_FAILURE);
    }
}
