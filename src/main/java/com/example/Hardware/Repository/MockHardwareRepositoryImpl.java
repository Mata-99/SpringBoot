package com.example.Hardware.Repository;

import com.example.Hardware.Domain.Hardware;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MockHardwareRepositoryImpl implements HardwareRepository{
    private static List<Hardware> hardwareList;

    static {
       hardwareList = new ArrayList<>();
       hardwareList.add(new Hardware( "RYZEN", "CPU01", 200.99, "CPU", 10 ,1));
       hardwareList.add(new Hardware( "ASUS","MBO001",  251.99,"GPU", 4,2 ));
       hardwareList.add(new Hardware("Kingston", "RAM001", 120.99, "RAM", 15,3));
    }
    @Override
    public Hardware getHardwareByName(String naziv ){
        for (Hardware hardware : hardwareList){
            if(hardware.getNaziv().equalsIgnoreCase(naziv)){
                return hardware;
            }
        }
        return null;
    }


    @Override
    public List<Hardware> getAllHardwares(String hardwareName) {
        return null;
    }

    @Override
    public Hardware saveHardware(Hardware hardware) {
       hardwareList.add(hardware);
       return hardware;
    }

    @Override
    public List<Hardware> getHardware(){
        return  this.hardwareList;
    }
    @Override
    public Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer id) {

        for (int i = 0; i < hardwareList.size(); i++) {

            if (hardwareList.get(i).getId().equals(id)) {

                hardwareToUpdate.setId(id);

                hardwareList.set(i, hardwareToUpdate);

                return Optional.of(hardwareToUpdate);
            }
        }

        return Optional.empty();
    }

    @Override
    public Optional<Hardware> getHardwareById(Integer id) {
        return null;
    }

    @Override
    public boolean hardwareById(Integer id) {
        return hardwareList.stream()
                .anyMatch(h -> h.getId().equals(id));
    }

    @Override
    public boolean deleteHardware(Integer id) {
        return hardwareList.removeIf(h -> h.getId() != null && h.getId().equals(id));
    }
}




