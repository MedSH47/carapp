package com.carapp.carapp.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Cars")


public class Car {
    public enum RPM{
    X4,
    X5,
    X6,
    X7,
    X8,
    X9,
    X10
}
    @Id
    private String id;
    private String marque;
    private String model;
    private Long kilometredistance;
    private int maxspeed;
    private Date year;
    private RPM  enginerpm;
    private int horsepower;
    private List<String> problems;
    private Long essence;
    private int gear;
    private float suspensionsystem;
    
    public Car(String id, String marque, String model, int maxspeed, Date year, RPM enginerpm, int horsepower,
            List<String> problems, Long essence, int gear, float suspensionsystem,Long kilometredistance) {
        this.kilometredistance=kilometredistance;
        this.id = id;
        this.marque = marque;
        this.model = model;
        this.maxspeed = maxspeed;
        this.year = year;
        this.enginerpm = enginerpm;
        this.horsepower = horsepower;
        this.problems = problems;
        this.essence = essence;
        this.gear = gear;
        this.suspensionsystem = suspensionsystem;
    }
    public Car() {
    }
    public Long getKilometredistance() {
        return kilometredistance;
    }
    public void setKilometredistance(Long kilometredistance) {
        this.kilometredistance = kilometredistance;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getMaxspeed() {
        return maxspeed;
    }
    public void setMaxspeed(int maxspeed) {
        this.maxspeed = maxspeed;
    }
    public Date getYear() {
        return year;
    }
    public void setYear(Date year) {
        this.year = year;
    }
    public RPM getEnginerpm() {
        return enginerpm;
    }
    public void setEnginerpm(RPM enginerpm) {
        this.enginerpm = enginerpm;
    }
    public int getHorsepower() {
        return horsepower;
    }
    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    public List<String> getProblems() {
        return problems;
    }
    public void setProblems(List<String> problems) {
        this.problems = problems;
    }
    public Long getEssence() {
        return essence;
    }
    public void setEssence(Long essence) {
        this.essence = essence;
    }
    public int getGear() {
        return gear;
    }
    public void setGear(int gear) {
        this.gear = gear;
    }
    public float getSuspensionsystem() {
        return suspensionsystem;
    }
    public void setSuspensionsystem(float suspensionsystem) {
        this.suspensionsystem = suspensionsystem;
    }

   
    
    
}
