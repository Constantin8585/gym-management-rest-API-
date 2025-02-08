package com.gym.gym_app.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "pack_id")
    private Pack pack;
    private LocalDate startDate;
    private boolean activeSubscription;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Pack getPack() {
        return pack;
    }
    public void setPack(Pack pack) {
        this.pack = pack;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public boolean isActiveSubscription() {
        return activeSubscription;
    }
    public void setActiveSubscription(boolean activeSubscription) {
        this.activeSubscription = activeSubscription;
    }
    public Subscription(Long id, Customer customer, Pack pack, LocalDate startDate, boolean activeSubscription) {
        this.id = id;
        this.customer = customer;
        this.pack = pack;
        this.startDate = startDate;
        this.activeSubscription = activeSubscription;
    }
    public Subscription() {
    }
    public Subscription(Customer customer, Pack pack, LocalDate startDate, boolean activeSubscription) {
        this.customer = customer;
        this.pack = pack;
        this.startDate = startDate;
        this.activeSubscription = activeSubscription;
    }

}
