package com.example.Hardware.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@AllArgsConstructor

public class HardwareDTO {

    private String naziv;
    private Double cijena;
    private String tip;


}
