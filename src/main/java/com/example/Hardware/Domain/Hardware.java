package com.example.Hardware.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {

    private String naziv;
private  String sifra;
private  Double cijena;
private String tip;
private Integer kolicinaNaStanju;
private  Integer id;

}
