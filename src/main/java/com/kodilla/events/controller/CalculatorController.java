package com.kodilla.events.controller;

import com.kodilla.events.domain.InputDto;
import com.kodilla.events.domain.ResultDto;
import com.kodilla.events.util.Calculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/calculator")
public class CalculatorController {
    private final Calculator calculator;
    private static final Logger logger = LoggerFactory.getLogger(CalculatorController.class);

    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @PostMapping(path = "calculate")
    public ResponseEntity<ResultDto> calculate(@RequestBody InputDto inputDto) { //should validate
        logger.info("Register input: " + inputDto.a() + inputDto.operator() + inputDto.b());

        ResultDto result = new ResultDto(calculator.selectOperation(inputDto));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
