package com.example.Hardware.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HardwareDTO {

    private String naziv;
    private Double cijena;
    private String tip;

}
