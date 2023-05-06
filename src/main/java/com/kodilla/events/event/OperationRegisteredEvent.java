package com.kodilla.events.event;

import org.springframework.context.ApplicationEvent;

public class OperationRegisteredEvent extends ApplicationEvent {

    private long a;
    private long b;
    private String operator;
    private String operationType;

    public OperationRegisteredEvent(Object source, long a, long b, String operator, String operationType) {
        super(source);
        this.a = a;
        this.b = b;
        this.operator = operator;
        this.operationType = operationType;
    }

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public String getOperator() {
        return operator;
    }

    public String getOperationType() {
        return operationType;
    }
}
