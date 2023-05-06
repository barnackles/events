package com.kodilla.events.service;

import com.kodilla.events.event.OperationRegisteredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CalculatorManager implements ApplicationListener<OperationRegisteredEvent> {

    private static final Logger logger = LoggerFactory.getLogger(CalculatorManager.class);


    @Override
    public void onApplicationEvent(OperationRegisteredEvent event) {
        System.out.println("Event");
    logger.info(String.format("%s: %d %s %d.", event.getOperationType(), event.getA(), event.getOperator(), event.getB()));

    }
}
