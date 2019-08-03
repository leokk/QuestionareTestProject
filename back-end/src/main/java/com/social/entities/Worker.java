package com.social.entities;

import javax.persistence.*;

@Entity
@Table(name="Worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id ;
    private int age;
    private String firstName;
    private String lastName;
    private String phone;
    private int payment;
    private String position;


    public Worker() {
    }

    public int getAge() {
        return age;
    }

    public void updateWorker(Worker u){
        this.age = u.age;
        this.firstName = u.firstName;
        this.lastName = u.lastName;
        this.phone = u.phone;
        this.position = u.position;
        this.payment = u.payment;
    }

    public  Worker(int age, String firstName, String lastName, String phone, int payment, String position) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.payment = payment;
        this.position = position;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
