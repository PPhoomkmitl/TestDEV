package com.example.policyserviceproject.repository;

import com.example.policyserviceproject.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findByInsureName(String insureName);
}
