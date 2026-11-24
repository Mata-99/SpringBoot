package com.example.Hardware.Repository;

import com.example.Hardware.Domain.Hardware;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface HardwareRepository {
    List<Hardware> getHardware();
}
