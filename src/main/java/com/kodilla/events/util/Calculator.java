package com.kodilla.events.util;

import com.kodilla.events.domain.InputDto;
import org.springframework.stereotype.Component;

import static org.apache.el.lang.ELArithmetic.*;

@Component
public class Calculator {

    public String selectOperation(InputDto inputDto) {

        long a = inputDto.a();
        long b = inputDto.b();

        String operatorSpacesRemoved = removeSpace(inputDto.operator());
        String badOperatorMsg = "Unexpected operator";

        switch (operatorSpacesRemoved) {
            case "+" -> {
                return add(a, b).toString();
            }
            case "-" -> {
                return subtract(a, b).toString();
            }
            case "*" -> {
                return multiply(a, b).toString();
            }
            case "/" -> {
                return divide(a, b).toString();
            }
            default -> {
                return badOperatorMsg;
            }
        }


    }

    private String removeSpace(String operator) {

        return operator.replaceAll("\\s+", "");
    }

}
