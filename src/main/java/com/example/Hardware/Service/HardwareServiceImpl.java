package com.example.Hardware.Service;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Domain.HardwareDTO;
import com.example.Hardware.Repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements  HardwareService{

    HardwareRepository hardwareRepository;

    public Hardware getHardwareByName(String name) {
        return hardwareRepository.getHardwareByName(name);
    }



    @Override
    public Hardware saveHardware() {
        return null;
    }

    @Override
    public List<Hardware> getHardware() {
        return List.of();
    }

    @Override
    public List<HardwareDTO> getHardwareDTO() {

        return hardwareRepository.getHardware()
                .stream()
                .map(h -> new HardwareDTO(
                        h.getNaziv(),
                        h.getCijena(),
                        h.getTip()
                ))
                .toList();
    }
    @Override
    public Hardware saveHardware(HardwareDTO hardwareDTO){
         Hardware hardware = new Hardware(
                 hardwareDTO.getNaziv(),
                 "novi",
                 hardwareDTO.getCijena(),
                 hardwareDTO.getTip()
         );
         return hardwareRepository.saveHardware();
    }

}
