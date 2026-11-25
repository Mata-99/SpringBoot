package com.example.Hardware.Controller;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Domain.HardwareDTO;
import com.example.Hardware.Service.HardwareService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/hardware")
@AllArgsConstructor
public class HardwareController {

    private HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getHardwareDTO() {
        return hardwareService.getHardwareDTO();
    }

    @GetMapping("/{naziv}")
    public Hardware getHardwareByName(@PathVariable String naziv) {
        return hardwareService.getHardwareByName(naziv);
    }
    @PostMapping
    public Integer saveHardware(@Valid @RequestBody HardwareDTO hardwareDTO){
        Integer generatedId = hardwareService.saveHardware(hardwareDTO).getKolicinaNaStanju();
            return generatedId;
        }
    }





