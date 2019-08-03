package com.social.entities;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name="Servicess")
public class Service {

    public Service(){}

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id ;

    @Column(unique = true)
    private String description;

    @Column(unique = true, nullable = false)
    private String name;

    @Column( nullable = false)
    private int cost;

    @OneToMany(mappedBy = "service", cascade = {CascadeType.ALL},orphanRemoval = true)
    private Set<User> users;

    public Service(String description, String name, int cost) {
        this.description = description;
        this.name = name;
        this.cost = cost;
    }

    public Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public void updateService(Service s){
        this.description = s.description;
        this.name = s.name;
        this.cost = s.cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    //
//    private String input;
//
//    @OneToMany(mappedBy = "field", cascade = {CascadeType.ALL},orphanRemoval = true)
//    private Set<FieldUser> fld;
//
//    public Field(String input) {
//        this.input = input;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Field() {
//
//    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getInput() {
//        return input;
//    }
//
//    public void setInput(String input) {
//        this.input = input;
//    }

}
