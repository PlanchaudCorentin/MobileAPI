package com.atlantis.mobile_API;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/device/{deviceId}")
    public List<Sensor> findByDeviceId(@PathVariable Integer deviceId) {
        return this.sensorRepository.findByDeviceId(deviceId);
    }
}
