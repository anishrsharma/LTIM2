package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Insurance;
import com.wecp.progressive.service.InsuranceService;
import com.wecp.progressive.service.impl.InsuranceServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    InsuranceServiceImpl insuranceServiceImpl;

    @GetMapping
    public ResponseEntity<List<Insurance>> getAllInsurances() {
        try {
            return new ResponseEntity<>(insuranceServiceImpl.getAllInsurances(), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{insuranceId}")
    public ResponseEntity<Insurance> getInsuranceById(@PathVariable int insuranceId) {
        try {
            Insurance inr = insuranceServiceImpl.getInsuranceById(insuranceId);
            if(inr == null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(inr, HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createInsurance(Insurance insurance) {
        try {
            return new ResponseEntity<>(insuranceServiceImpl.getAllInsurances(), HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{insuranceId}")
    public ResponseEntity<Void> updateInsurance(int insuranceId, Insurance insurance) {
        try {
            insurance.setInsuranceId(insuranceId);
            insuranceServiceImpl.updateInsurance(insurance);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> deleteInsurance(int insuranceId) {
        try {
            insuranceServiceImpl.getAllInsurances();
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
