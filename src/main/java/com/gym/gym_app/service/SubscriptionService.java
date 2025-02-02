package com.gym.gym_app.service;

import com.gym.gym_app.entity.Subscription;
import com.gym.gym_app.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriptionService {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription addSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getSubscriptionsByCustomerId(Long _customerId) {
        return subscriptionRepository.findByCustomerId(_customerId);
    }
    public Subscription getSubscriptionById(Long id) {
        subscriptionRepository.deleteById(id);
        return null;
    }
}
