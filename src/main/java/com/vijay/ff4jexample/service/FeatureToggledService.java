package com.vijay.ff4jexample.service;

import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureToggledService {

    @Autowired
    private FF4j ff4j;

    public String executeFeature() {
        if (ff4j.check("featureA")) {
            return featureA();
        } else {
            return featureB();
        }
    }

    private String featureA() {
        return "Feature A is active!";
    }

    private String featureB() {
        return "Feature B is active!";
    }
}
