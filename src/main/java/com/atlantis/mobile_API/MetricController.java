package com.atlantis.mobile_API;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metrics")
public class MetricController {
    private final MetricRepository metricRepository;

    public MetricController(MetricRepository metricRepository){

        this.metricRepository = metricRepository;
    }

    @CrossOrigin
    @GetMapping
    public List<Metric> findAll(){

        return this.metricRepository.findAll();

    }

    @CrossOrigin
    @GetMapping("/sensor/{sensorId}")
    public List<Metric> findBySensorId(@PathVariable Integer sensorId) {
        return this.metricRepository.findBySensorId(sensorId);
    }
}
