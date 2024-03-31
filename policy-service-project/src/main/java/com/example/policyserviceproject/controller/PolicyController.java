package com.example.policyserviceproject.controller;

import com.example.policyserviceproject.error.HandleUserException;
import com.example.policyserviceproject.model.Policy;
import com.example.policyserviceproject.model.PolicyRequest;
import com.example.policyserviceproject.model.PolicyResponse;
import com.example.policyserviceproject.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.example.policyserviceproject.model.Error.*;

@RestController
@RequestMapping(path = "api/v1")
public class PolicyController {

    private final PolicyService service;

    @Autowired
    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @GetMapping("/get/policy")
    public ResponseEntity<PolicyResponse> getPolicyByInsureName(@RequestHeader("messageId") String messageId,
                                                                @RequestHeader("sentDateTime")
                                                                @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
                                                                Date sentDateTime,
                                                                @RequestBody PolicyRequest body) {



        if (messageId == null || messageId.isEmpty()) {
            throw new HandleUserException(BAD_MESSAGE.getCode() , BAD_MESSAGE.getMessage());
        }

        if (sentDateTime == null) {
            throw new HandleUserException(BAD_DATE.getCode() , BAD_DATE.getMessage());
        }

        if ((body.getInsureName() == null || (body.getInsureName().isEmpty()))) {
            throw new HandleUserException(EMPTY_INSURE.getCode() , EMPTY_INSURE.getMessage());
        }

        List<Policy> policies = service.getPolicyByInsureName(body.getInsureName());
        PolicyResponse response = new PolicyResponse("S", policies );

        Date formattedResponseDateTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String responseDateTime = dateFormat.format(formattedResponseDateTime);

        return ResponseEntity.ok()
                .header("messageId", messageId)
                .header("sentDateTime", sentDateTime.toString())
                .header("responseDateTime", responseDateTime)
                .body(response);

    }

}
