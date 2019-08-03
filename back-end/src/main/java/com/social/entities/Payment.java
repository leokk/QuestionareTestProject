package com.social.entities;

import javax.persistence.*;

@Entity
@Table(name="Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id ;

    @Column(nullable = false)
    private int sum;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment(int sum) {
        this.sum = sum;
    }

    public Payment(int sum, User user) {
        this.sum = sum;
        this.user = user;
    }
}
