package com.example.test_work;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
    
    // Геттеры
    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public User getOwner() {
        return owner;
    }

    // Сеттеры
    public void setId(Long id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
