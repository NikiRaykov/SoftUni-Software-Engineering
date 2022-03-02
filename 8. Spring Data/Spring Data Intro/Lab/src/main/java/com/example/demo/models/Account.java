package com.example.demo.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private BigDecimal balance;

    @ManyToOne
    private User user;

    public Account(){}

    public Account(BigDecimal balance){
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
