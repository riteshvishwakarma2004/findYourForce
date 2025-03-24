package com.ritesh.FindYourForce.dto;

import lombok.*;


public class TradespersonDto {




//    private Integer id;
    private String name;
    private String phone1;
    private String phone2;
    private String expertise;
    private String locality;
    private String availability;

    public TradespersonDto( String name, String phone1, String phone2, String expertise, String locality, String availability) {
//        this.id = id;
        this.name = name;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.expertise = expertise;
        this.locality = locality;
        this.availability = availability;
    }

    public TradespersonDto() {
    }

//    public Integer getId() {
//        return id;
//    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

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

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
}
