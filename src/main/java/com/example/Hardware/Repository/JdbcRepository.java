package com.example.Hardware.Repository;

import com.example.Hardware.Domain.Hardware;
import com.example.Hardware.RowMapper.HardwareRowMapperImpl;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



@Primary
@Repository
@AllArgsConstructor
public class JdbcRepository implements HardwareRepository{
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Hardware> getAllHardwares(String hardwareName){
        return jdbcTemplate.query("SELECT * FROM Hardware WHERE naziv", new HardwareRowMapperImpl(), hardwareName);
    }


    @Override
    public Hardware saveHardware(Hardware hardware) {

        final String sql = "SELECT id FROM FINAL TABLE (INSERT INTO Hardware(naziv, cijena, tip, id) VALUES(?, ?, ?, ?))Hardware";
                Integer generatedId = jdbcTemplate.queryForObject(sql, Integer.class, hardware.getNaziv(), hardware.getCijena(), hardware.getTip(), hardware.getId());
        hardware.setId(generatedId);
        return  hardware;
    }

    @Override
    public List<Hardware> getHardware() {
        return jdbcTemplate.query(
                "SELECT * FROM Hardware",
                new HardwareRowMapperImpl()
        );
    }

    @Override
    public Hardware getHardwareByName(String naziv) {
        return (Hardware) jdbcTemplate.queryForObject(
                "SELECT * FROM Hardware WHERE naziv = ?",
                new HardwareRowMapperImpl(),
                naziv
        );
    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer id) {
        if (hardwareById(id)) {
            final String sql = "UPDATE Hardware SET naziv = ? , cijena = ?, tip = ?, id = ? WHERE  id = ?";
            jdbcTemplate.update(connection -> {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, hardwareToUpdate.getNaziv());
                preparedStatement.setDouble(2, hardwareToUpdate.getCijena());
                preparedStatement.setString(3, hardwareToUpdate.getTip());
                preparedStatement.setInt(4, hardwareToUpdate.getId());

                return preparedStatement;
            });
            hardwareToUpdate.setId(id);
            return Optional.of(hardwareToUpdate);
        }
        else {
            return  Optional.empty();
        }
    }

    @Override
    public Optional<Hardware> getHardwareById(Integer id) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        return Optional.ofNullable((Hardware) jdbcTemplate.queryForObject("SELECT * FROM Hardware WHERE id = ?" , new HardwareRowMapperImpl(), parameters));
    }

    @Override
    public boolean hardwareById(Integer id) {
        Integer count = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM Hardware WHERE id = ?", Integer.class, id);
        return  count > 0;
    }

    @Override
    public boolean deleteHardware(Integer id) {
        if(hardwareById(id)){
            jdbcTemplate.update("DELETE FROM Hardware WHERE id = ? ", id);
            return  true;
        }
        else {
            return false;
        }
    }
}
