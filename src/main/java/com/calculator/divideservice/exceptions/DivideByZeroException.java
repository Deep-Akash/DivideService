package com.calculator.divideservice.exceptions;

import com.calculator.divideservice.enums.APIResponseCodeENUM;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public class DivideByZeroException extends APIBaseException {
    public DivideByZeroException() {
        super(APIResponseCodeENUM.WRONG_FORMAT);
    }
}
