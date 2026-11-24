package com.example.Hardware.Service;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements  HardwareService{

    HardwareRepository hardwareRepository;

    @Override
    public List<Hardware> getHardware(){
        return  hardwareRepository.getHardware();
    }

}
