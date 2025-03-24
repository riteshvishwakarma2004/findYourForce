package com.ritesh.FindYourForce.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Tradesperson {



    private String name;
    @Id
    private String phone1;
    private String phone2;
    private Integer pin;
    private String expertise;
    private String locality;
    private String availability;

    public Tradesperson( String name, String phone1, String phone2, String expertise, String locality,Integer pin, String availability) {
       // this.id = id;
        this.name = name;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.expertise = expertise;
        this.locality = locality;
        this.pin = pin;
        this.availability = availability;
    }

    public Tradesperson() {

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
