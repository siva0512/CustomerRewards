package com.test.rewards.controller;

import com.test.rewards.dto.RewardsDto;
import com.test.rewards.service.RewardsService;
import com.test.rewards.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rewards")
public class RewardsController {

    @Autowired
    private RewardsService service;

    @GetMapping("/get")
    public ResponseEntity<?> getRewardPoints(@RequestParam("customerId") String customerId,
                                             @RequestParam("startDate") String startDate) {
        System.out.println("inside get reward points for the user");
        if(Utils.validDate(startDate))
            return ResponseEntity.ok(new RewardsDto(service.getRewardPoints(customerId, startDate)));
        else
            return ResponseEntity.badRequest().body("Invalid Date");
    }
}