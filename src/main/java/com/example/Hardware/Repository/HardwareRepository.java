package com.example.Hardware.Repository;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Domain.HardwareDTO;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


public interface HardwareRepository {
    List<Hardware> getHardware();




}
