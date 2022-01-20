package com.test.rewards.service;

import com.test.rewards.controller.RewardsController;
import com.test.rewards.dao.OrderRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.test.rewards.util.Utils.lessThreeMonths;

@Service
public class RewardsService {
    private static final Logger LOGGER = LogManager.getLogger(RewardsController.class.getName());

    @Autowired
    private OrderRepository repository;

    public int getRewardPoints(String customerId, String startDate) {

        return repository.getOrderDetails(customerId, startDate, lessThreeMonths(startDate)).stream().map(order -> {
            double amount = order.getTotalAmount();
            int points = 0;
            if(amount>50){
                int tempAmount = (int)amount - 50;
                if(tempAmount > 50){
                    points = 50 + ((tempAmount-50)*2);
                }else{
                    points = tempAmount;
                }
            }
            return points;
        }).reduce(0, Integer::sum);
    }
}
