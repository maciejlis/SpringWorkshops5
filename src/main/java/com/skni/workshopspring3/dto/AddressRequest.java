package com.skni.workshopspring3.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AddressRequest {

    @NotBlank(message = "Street is mandatory")
    @Size(min = 3, max = 15)
    private String street;

    @NotBlank(message = "City is mandatory")
    @Size(min = 3, max = 15)
    private String city;
    private String country;
}
