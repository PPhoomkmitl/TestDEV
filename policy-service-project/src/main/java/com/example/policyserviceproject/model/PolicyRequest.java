package com.example.policyserviceproject.model;

public class PolicyRequest {
    String insureName;

    public PolicyRequest() {

    }

    public PolicyRequest(String insureName) {
        this.insureName = insureName;
    }

    public String getInsureName() {
        return insureName;
    }

    public void setInsureName(String insureName) {
        this.insureName = insureName;
    }
}
