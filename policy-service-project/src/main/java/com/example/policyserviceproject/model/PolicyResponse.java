package com.example.policyserviceproject.model;

import java.util.List;

public class PolicyResponse {

    String status;
    List<Policy> policies ;

    public PolicyResponse() {

    }

    public PolicyResponse(String status ,List<Policy> policies) {
        this.status = status;
        this.policies = policies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

}
