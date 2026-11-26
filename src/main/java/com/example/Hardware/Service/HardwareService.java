package com.example.Hardware.Service;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Domain.HardwareDTO;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

     List<Hardware> getHardware();
     List<HardwareDTO> getHardwareDTO();
     Hardware getHardwareByName(String name);
     Hardware saveHardware(Hardware hardware);
     Optional<HardwareDTO> updateHardware(HardwareDTO hardwareDTO, Integer id);


     boolean hardwareByid(Integer id);

     boolean deleteHardware(Integer id);
}
