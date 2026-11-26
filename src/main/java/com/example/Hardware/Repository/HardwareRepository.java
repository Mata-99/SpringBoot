package com.example.Hardware.Repository;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Domain.HardwareDTO;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public interface HardwareRepository {
    List<Hardware> getAllHardwares(String hardwareName);

    Hardware saveHardware(Hardware hardware);
    List<Hardware> getHardware();
    Hardware getHardwareByName(String naziv);
    Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer id);
    Optional<Hardware>getHardwareById(Integer id);

    boolean hardwareById(Integer id);

    boolean deleteHardware(Integer id);
}
