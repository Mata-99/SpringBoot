package com.example.Hardware.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hardware {


    private String naziv;
private  String sifra;
private  Double cijena;
private String tip;
private Integer kolicinaNaStanju;


    public Hardware(String naziv, String novi, Double cijena, String tip) {
    }
}
