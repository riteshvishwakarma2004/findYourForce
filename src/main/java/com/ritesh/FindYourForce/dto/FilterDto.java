package com.ritesh.FindYourForce.dto;

import lombok.Getter;
import lombok.Setter;

public class FilterDto {

    private String expertise;

    private String locality;

    public FilterDto(String expertise, String locality) {
        this.expertise = expertise;
        this.locality = locality;
    }

    public FilterDto() {
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
}
