package com.atlantis.mobile_API;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    private final DeviceRepository deviceRepository;

    public DeviceController(DeviceRepository deviceRepository){
        this.deviceRepository = deviceRepository;
    }

    @CrossOrigin
    @GetMapping
    public List<Device> findAll(){
        return  this.deviceRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/id/{id}")
    public Device findById(@PathVariable Long id) {
        return this.deviceRepository.findById(id).get();
    }

    @CrossOrigin
    @GetMapping("/name/{name}")
    public Device findByName(@PathVariable String name) {
        return this.deviceRepository.findByName(name);
    }

    @CrossOrigin
    @PostMapping("/new")
    public Device newDevice(@RequestBody Device newDevice){
        System.out.println(newDevice);
        return deviceRepository.save(newDevice);
    }
}
