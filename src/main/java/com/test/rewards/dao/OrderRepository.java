package com.test.rewards.dao;

import com.test.rewards.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order, Long>{

    @Query("{'customerId' : ?0}")
    public List<Order> finByCustomerId(String customerId);

    @Query("{orderedDate : {$lte : ?0, $gte : ?1}}")
    public List<Order> findBetweenDates(String startDate, String endDate);

    @Query(value = "{ $and: [ {'customerId' : ?0}, {orderedDate : {$lte : ?0, $gte : ?1}} ] }")
    public List<Order> getOrderDetails(String customerId, String startDate, String endDate);
}
