package com.example.Hardware.RowMapper;

import com.example.Hardware.Domain.Hardware;

import java.sql.ResultSet;

public interface RowMapper{

    Hardware mapRow(ResultSet rs, int rowNum);
}
