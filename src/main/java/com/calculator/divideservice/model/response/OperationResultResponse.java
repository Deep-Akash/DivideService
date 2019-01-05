package com.calculator.divideservice.model.response;

/**
 * Created by akashdeepnew on 20/12/18.
 */
public class OperationResultResponse {
    private Number result;
    private Number cost;

    public OperationResultResponse() {
    }

    public OperationResultResponse(Number result, Number cost) {
        this.result = result;
        this.cost = cost;
    }

    public OperationResultResponse(Number result) {
        this.result = result;
    }

    public Number getResult() {
        return result;
    }

    public Number getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "OperationResultResponse{" +
                "result=" + result +
                ", cost=" + cost +
                '}';
    }
}
