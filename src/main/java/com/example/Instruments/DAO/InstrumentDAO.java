package com.example.Instruments.DAO;

import com.example.Instruments.Entity.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: Instruments
 * @description:
 * @author: Siyu Hou
 * @create: 2023-06-17 16:07
 **/
@Repository
public class InstrumentDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public InstrumentDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Instrument createInstrument(Instrument instrument) {
        String sql = "INSERT INTO instrument (id, instrument_name, instrument_info) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, instrument.getId(), instrument.getName(), instrument.getInfo());
        return instrument;
    }

    public List<Instrument> listAllInstruments() {
        String sql = "SELECT * FROM Instrument";
        return jdbcTemplate.query(sql, (resultSet, row) -> {
            Instrument instrument = new Instrument();
            instrument.setId(resultSet.getInt("id"));
            instrument.setName(resultSet.getString("instrument_name"));
            instrument.setInfo(resultSet.getString("instrument_info"));
            return instrument;
        });
    }
}
