package com.test.rewards.controller;

import com.test.rewards.dto.RewardsDto;
import com.test.rewards.service.RewardsService;
import com.test.rewards.util.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rewards")
public class RewardsController {

    private static final Logger LOGGER = LogManager.getLogger(RewardsController.class.getName());

    @Autowired
    private RewardsService service;

    @GetMapping("/get")
    public ResponseEntity<?> getRewardPoints(@RequestParam("customerId") String customerId,
                                             @RequestParam("startDate") String startDate) {
        LOGGER.info("inside get reward points for the user");
        if(Utils.validDate(startDate))
            return ResponseEntity.ok(new RewardsDto(service.getRewardPoints(customerId, startDate)));
        else
            return ResponseEntity.badRequest().body("Invalid Date");
    }
}