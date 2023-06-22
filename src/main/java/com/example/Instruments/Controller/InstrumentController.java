package com.example.Instruments.Controller;

import com.example.Instruments.Entity.Instrument;
import com.example.Instruments.Service.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: Instruments
 * @description:
 * @author: Siyu Hou
 * @create: 2023-06-17 16:29
 **/
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class InstrumentController {
    private final InstrumentService service;

    @Autowired
    public InstrumentController(InstrumentService service) {
        this.service = service;
    }

    @PostMapping(value = "/instrument", consumes = "application/json")
    public ResponseEntity<Object> createInstrument(@RequestBody Instrument instrument) {
        try {
            Instrument createInstrument = service.createInstrument(instrument);
            return new ResponseEntity<>(createInstrument, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e);
        }
    }


    @GetMapping(value = "/instruments")
    public List<Instrument> listAllInstruments() {
        return service.listAllInstruments();
    }
}
