package com.at.asset_tracker.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, optional = false)
    private Portfolio portfolio;

    protected User() {}

    public User(String email, String name) {
        this.email = email;
        this.name = name;
        this.portfolio = new Portfolio(this);
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }
}

