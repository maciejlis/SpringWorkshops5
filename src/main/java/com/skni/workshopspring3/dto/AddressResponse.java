package com.skni.workshopspring3.dto;

import lombok.Data;

@Data
public class AddressResponse {
    private String street;
    private String city;
    private String country;
}
