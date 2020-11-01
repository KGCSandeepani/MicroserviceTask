package com.gcts.plan.Service;

import com.gcts.plan.Repositary.PlanRepository;
import com.gcts.plan.exception.ResourceNotFoundException;
import com.gcts.plan.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chamodi Sandeepani on 2/22/2020.
 */

@Service
public class PlanService {

    @Autowired
    PlanRepository planRepository;

    // Get All Plans
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    // Create a new Plan
    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    // Get a Single Plan
    public Plan getPlanById(Integer pid) {
        return planRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Plan", "pid", pid));
    }

    // Update a Plan
    public Plan updatePlan( Integer pid, Plan planDetails) {

        Plan plan = planRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Plan", "pid", pid));

        plan.setType(planDetails.getType());
        plan.setCreatedAt(planDetails.getCreatedAt());
        plan.setUpdatedAt(planDetails.getUpdatedAt());

        Plan updatedPlan = planRepository.save(plan);
        return updatedPlan;
    }

    // Delete a Plan
    public ResponseEntity<?> deletePlan( Integer pid) {
        Plan plan = planRepository.findById(pid)
                .orElseThrow(() -> new ResourceNotFoundException("Plan", "pid", pid));

        planRepository.delete(plan);

        return ResponseEntity.ok().build();
    }
}
