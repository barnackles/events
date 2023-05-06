package com.kodilla.events.controller;

import com.kodilla.events.domain.InputDto;
import com.kodilla.events.domain.ResultDto;
import com.kodilla.events.util.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/calculator")
public class CalculatorController implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;
    private Calculator calculator;
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    public CalculatorController(ApplicationEventPublisher publisher, Calculator calculator) {
        this.publisher = publisher;
        this.calculator = calculator;
    }

    @PostMapping(path = "calculate")
    public ResponseEntity<ResultDto> calculate(@RequestBody InputDto inputDto) { //should validate
        logger.info("Register input: " + inputDto.a() + inputDto.operator() + inputDto.b());

    // TODO input processing logic

        ResultDto result = new ResultDto(calculator.selectOperation(inputDto));

//        publisher.publishEvent(
//                new ProductRegisteredEvent(
//                        this,
//                        productDto.getProductName(),
//                        productDto.getOtherData()));



        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
