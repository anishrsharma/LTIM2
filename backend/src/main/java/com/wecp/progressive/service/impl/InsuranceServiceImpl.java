package com.wecp.progressive.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Insurance;
import com.wecp.progressive.repository.InsuranceRepository;
import com.wecp.progressive.service.InsuranceService;

@Service
public class InsuranceServiceImpl implements InsuranceService  {
    
    @Autowired
    InsuranceRepository insuranceRepository;

    @Override
    public List<Insurance> getAllInsurances() {
        // TODO Auto-generated method stub
        return insuranceRepository.findAll();
    }

    @Override
    public int addInsurance(Insurance insurance) {
        // TODO Auto-generated method stub
        return insuranceRepository.save(insurance).getInsuranceId();
    }

    @Override
    public Insurance getInsuranceById(int insuranceId) {
        // TODO Auto-generated method stub
        return insuranceRepository.findById(insuranceId).orElse(null);
    }

    @Override
    public void updateInsurance(Insurance insurance) {
        insuranceRepository.save(insurance);
        
    }

    @Override
    public void deleteInsurance(int insuranceId) {
        // TODO Auto-generated method stub
        insuranceRepository.deleteById(insuranceId);
    }

}