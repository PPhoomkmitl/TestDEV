package com.example.policyserviceproject.service;

import com.example.policyserviceproject.error.HandleUserException;
import com.example.policyserviceproject.model.Policy;
import com.example.policyserviceproject.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.policyserviceproject.model.Error.NOT_FOUND_INSURE;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyService(PolicyRepository policyRepository) {

        this.policyRepository = policyRepository;
    }

    public List<Policy> getPolicyByInsureName(String insureName) {;
        List<Policy> policies = policyRepository.findByInsureName(insureName);
        if (policies.isEmpty()) {
            throw new HandleUserException(NOT_FOUND_INSURE.getCode() , NOT_FOUND_INSURE.getMessage());
        }
        return policies;
    }
}
