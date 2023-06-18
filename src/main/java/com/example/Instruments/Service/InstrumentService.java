package com.example.Instruments.Service;

import com.example.Instruments.DAO.InstrumentDAO;
import com.example.Instruments.Entity.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: Instruments
 * @description:
 * @author: Siyu Hou
 * @create: 2023-06-17 16:26
 **/
@Service
public class InstrumentService {
    private final InstrumentDAO instrumentDAO;

    @Autowired
    public InstrumentService(InstrumentDAO instrumentDAO) {
        this.instrumentDAO = instrumentDAO;
    }

    @Transactional
    public Instrument createInstrument(Instrument instrument) {
        return instrumentDAO.createInstrument(instrument);
    }
}
