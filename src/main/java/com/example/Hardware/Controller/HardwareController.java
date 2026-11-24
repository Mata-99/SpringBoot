package com.example.Hardware.Controller;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hardware")
@AllArgsConstructor
public class HardwareController {
private HardwareService hardwareService;
@GetMapping
    public List<Hardware> getHardware(){
    return hardwareService.getHardware();
}
}
