package com.example.Hardware.Controller;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Domain.HardwareDTO;
import com.example.Hardware.Service.HardwareService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


import org.springframework.http.ResponseEntity;
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
    public Hardware saveHardware(@Valid @RequestBody Hardware Hardware){
        Hardware generatedId = hardwareService.saveHardware(Hardware);
            return generatedId;
        }
        @PutMapping("/{id}")
    public ResponseEntity<?> hardwareUpdate(@Valid @RequestBody HardwareDTO hardwareDTO, @PathVariable Integer id){
        if(hardwareService.hardwareByid(id)) {
            hardwareService.updateHardware(hardwareDTO, id);
            return  ResponseEntity.ok(hardwareDTO);
        }
        else {
            return  ResponseEntity.notFound().build();
        }
        }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> hardwareDelete(@PathVariable Integer id) {
        if (hardwareService.deleteHardware(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    }





