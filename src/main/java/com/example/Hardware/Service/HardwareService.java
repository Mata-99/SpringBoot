package com.example.Hardware.Service;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Domain.HardwareDTO;

import java.util.List;

public interface HardwareService {

List<Hardware> getHardware();
     List<HardwareDTO> getHardwareDTO();
}
