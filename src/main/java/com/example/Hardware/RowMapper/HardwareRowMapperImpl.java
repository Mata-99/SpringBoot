package com.example.Hardware.RowMapper;


import com.example.Hardware.Domain.Hardware;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HardwareRowMapperImpl implements  RowMapper{
    @Override
    public Hardware mapRow(ResultSet rs, int rowNum)throws SQLException{
        Hardware hardware = new Hardware();

        hardware.setId(rs.getInt("id"));
        hardware.setNaziv(rs.getNString("naziv"));
        hardware.setTip(rs.getNString("tip"));
        hardware.setCijena(rs.getDouble("cijena"));

        return  hardware;
    }
}
