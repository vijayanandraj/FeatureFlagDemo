package com.vijay.ff4jexample.controller;

import com.vijay.ff4jexample.service.FeatureToggledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeatureToggleController {

    @Autowired
    private FeatureToggledService featureToggledService;

    @GetMapping("hello")
    public String helloWorld(){
        return "FF4J Hello World";
    }

    @GetMapping("/execute-feature")
    public String executeFeature() {
        return featureToggledService.executeFeature();
    }
}
