package com.example.Hardware.Repository;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.Domain.HardwareDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MockHardwareRepositoryImpl implements HardwareRepository{
    private static List<Hardware> hardwareList;

    static {
       hardwareList = new ArrayList<>();
       hardwareList.add(new Hardware("RYZEN", "CPU01", 200.99, "CPU", 10 ));
       hardwareList.add(new Hardware("ASUS","MBO001",  251.99,"GPU", 4));
       hardwareList.add(new Hardware("Kingston", "RAM001", 120.99, "RAM", 15));
    }
    @Override
    public List<Hardware> getHardware(){
        return  this.hardwareList;
    }



}
