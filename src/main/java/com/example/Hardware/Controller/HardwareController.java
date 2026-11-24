package com.example.Hardware.Controller;

import com.example.Hardware.Domain.HardwareDTO;
import com.example.Hardware.Service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hardware")
@AllArgsConstructor
public class HardwareController {

private HardwareService hardwareService;

@GetMapping
    public List<HardwareDTO> getHardwareDTO(){
    return hardwareService.getHardwareDTO();
}
    @GetMapping("/{hardware1}")
    public ResponseEntity<List<HardwareDTO>> filterHardware(
            @PathVariable String hardware) {
        return ResponseEntity.ok(hardwareService.getHardwareDTO().stream().toList());
    }
}


