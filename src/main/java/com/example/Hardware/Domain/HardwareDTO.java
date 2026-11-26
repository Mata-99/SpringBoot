package com.example.Hardware.Domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardwareDTO {

    @NotBlank(message = "Naziv je obavezan")
    private String naziv;

    @NotNull(message = "Cijena je obavezna")
    @Positive(message = "Cijena mora biti veca od 0")
    private Double cijena;

    @NotBlank(message = "Tip je obavezan")
    private String tip;

}
