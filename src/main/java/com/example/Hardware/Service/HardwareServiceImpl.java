package com.example.Hardware.Service;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Domain.HardwareDTO;
import com.example.Hardware.Repository.HardwareRepository;
import lombok.AllArgsConstructor;
import java.util.Optional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements  HardwareService{
    private Hardware convertHardwareDtoToHardware(HardwareDTO dto) {

        return new Hardware(
                dto.getNaziv(),
                "UPDATE",
                dto.getCijena(),
                dto.getTip(),
                0,
                null
        );
    }
    private HardwareDTO convertHardwareDtoToHardwareDTO(Hardware hardware) {

        return new HardwareDTO(
                hardware.getNaziv(),
                hardware.getCijena(),
                hardware.getTip()
        );
    }
    HardwareRepository hardwareRepository;

    public Hardware getHardwareByName(String name) {
        return hardwareRepository.getHardwareByName(name);
    }


    @Override
    public List<Hardware> getHardware() {
        return hardwareRepository.getHardware();
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
    public Hardware saveHardware(Hardware hardware) {
        return hardwareRepository.saveHardware(hardware);
    }
    @Override
    public boolean hardwareByid(Integer id) {
        return hardwareRepository.hardwareById(id);
    }

    @Override
    public Optional<HardwareDTO> updateHardware(HardwareDTO hardwareDTO, Integer id){
        Optional<Hardware> updateHardwareOptional = hardwareRepository.updateHardware(convertHardwareDtoToHardware(hardwareDTO), id);

        if (updateHardwareOptional.isPresent()) {
            return Optional.of(
                    convertHardwareDtoToHardwareDTO(
                            updateHardwareOptional.get()
                    )
            );
        }
        return Optional.empty();
    }
    @Override
    public boolean deleteHardware(Integer id) {
        return hardwareRepository.deleteHardware(id);
    }

}
