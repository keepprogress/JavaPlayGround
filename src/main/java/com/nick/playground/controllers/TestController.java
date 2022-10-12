package com.nick.playground.controllers;

import com.nick.playground.services.PropagationServiceA;
import com.nick.playground.services.PropagationServiceB;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "測試用Controller")
@RestController
@RequestMapping("/TestController")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private PropagationServiceB serviceB;

    @Autowired
    private PropagationServiceA serviceA;

    @ApiOperation(value = "測試propagation", notes = "測試propagation")
    @PostMapping(value = "/goPropagation")
    public String goPropagation() {
        try {
            throw new RuntimeException("new test runtime exception... ");
        } catch (Exception e) {
            return "in catch block";
        } finally {
            logger.info("log within finally block");

        }
    }
}
