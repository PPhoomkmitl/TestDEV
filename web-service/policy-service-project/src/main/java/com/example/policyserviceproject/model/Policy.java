package com.example.policyserviceproject.model;

import jakarta.persistence.*;

@Entity
@Table
public class Policy {

    @Id
    @SequenceGenerator(
            name = "policy_sequence",
            sequenceName = "policy_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "policy_sequence"
    )

    private Long id;

    @Column(name="insure_name" , length = 100)
    private String insureName;

    @Column(length = 6)
    private String policyNo;

    @Column(length = 2)
    private String policyType;

    @Column(length = 1)
    private String status;

    @Column(length = 8)
    private String agentID;


    public Policy(Long id, String insureName, String policyNo, String policyType, String status, String agentID) {
        this.id = id;
        this.insureName = insureName;
        this.policyNo = policyNo;
        this.policyType = policyType;
        this.status = status;
        this.agentID = agentID;
    }

    public Policy(String insureName, String policyNo, String policyType, String status, String agentID) {
        this.insureName = insureName;
        this.policyNo = policyNo;
        this.policyType = policyType;
        this.status = status;
        this.agentID = agentID;
    }

    public Policy() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInsureName() {
        return insureName;
    }

    public void setInsureName(String insureName) {
        this.insureName = insureName;
    }

    public String getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(String policyNo) {
        this.policyNo = policyNo;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgentID() {
        return agentID;
    }

    public void setAgentID(String agentID) {
        this.agentID = agentID;
    }
}
