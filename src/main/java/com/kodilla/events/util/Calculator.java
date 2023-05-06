package com.kodilla.events.util;

import com.kodilla.events.domain.InputDto;
import com.kodilla.events.event.OperationRegisteredEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import static org.apache.el.lang.ELArithmetic.*;

@Component
public class Calculator implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    public String selectOperation(InputDto inputDto) {

        long a = inputDto.a();
        long b = inputDto.b();

        String operatorSpacesRemoved = removeSpace(inputDto.operator());
        String badOperatorMsg = "Unexpected operator";

        switch (operatorSpacesRemoved) {
            case "+" -> {
                publisher.publishEvent(
                        new OperationRegisteredEvent(
                                this,
                                a,
                                b,
                                operatorSpacesRemoved,
                                "Adding"));
                return add(a, b).toString();
            }
            case "-" -> {
                publisher.publishEvent(
                        new OperationRegisteredEvent(
                                this,
                                a,
                                b,
                                operatorSpacesRemoved,
                                "Subtracting"));
                return subtract(a, b).toString();
            }
            case "*" -> {
                publisher.publishEvent(
                        new OperationRegisteredEvent(
                                this,
                                a,
                                b,
                                operatorSpacesRemoved,
                                "Multiplying"));
                return multiply(a, b).toString();
            }
            case "/" -> {
                publisher.publishEvent(
                        new OperationRegisteredEvent(
                                this,
                                a,
                                b,
                                operatorSpacesRemoved,
                                "Dividing"));
                return divide(a, b).toString();
            }
            default -> {
                publisher.publishEvent(
                        new OperationRegisteredEvent(
                                this,
                                a,
                                b,
                                operatorSpacesRemoved,
                                badOperatorMsg));
                return badOperatorMsg;
            }
        }


    }

    private String removeSpace(String operator) {

        return operator.replaceAll("\\s+", "");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

}
