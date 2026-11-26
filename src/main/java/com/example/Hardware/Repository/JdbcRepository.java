package com.example.Hardware.Repository;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.RowMapper.HardwareRowMapperImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;



@Primary
@Repository
@AllArgsConstructor
public class JdbcRepository implements HardwareRepository{
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Hardware> getAllHardwares(String hardwareName){
        return jdbcTemplate.query("SELECT * FROM Hardawre", new HardwareRowMapperImpl());
    }


    @Override
    public Hardware saveHardware(Hardware hardware) {
        hardware.
        return hardware;
    }

    @Override
    public List<Hardware> getHardware() {
        return List.of();
    }

    @Override
    public Hardware getHardwareByName(String naziv) {
        return null;
    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Hardware> getHardwareById(Integer id) {
        return Optional.empty();
    }

    @Override
    public boolean hardwareById(Integer id) {
        return false;
    }

    @Override
    public boolean deleteHardware(Integer id) {
        return false;
    }
}
