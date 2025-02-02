package com.gym.gym_app.controller;

import com.gym.gym_app.entity.Subscription;
import com.gym.gym_app.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public Subscription addSubscription(@RequestBody Subscription subscription) {
        return subscriptionService.addSubscription(subscription);
    }

    @GetMapping("/customer/{customerId}")
    public List<Subscription> getSubscriptionsByCustomerId(@PathVariable Long customerId) {
        return subscriptionService.getSubscriptionsByCustomerId(customerId);
    }
}
