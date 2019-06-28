package com.atlantis.mobile_API;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorRepository sensorRepository;

    public SensorController(SensorRepository sensorRepository){

        this.sensorRepository = sensorRepository;
    }

    @CrossOrigin
    @GetMapping
    public List<Sensor> findAll(){

        return this.sensorRepository.findAll();

    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Sensor findById(@PathVariable long id){
        return this.sensorRepository.findById(id);
    }

    @CrossOrigin
    @GetMapping("/device/{deviceId}")
    public List<Sensor> findByDeviceId(@PathVariable Integer deviceId) {
        return this.sensorRepository.findByDeviceId(deviceId);
    }
}
