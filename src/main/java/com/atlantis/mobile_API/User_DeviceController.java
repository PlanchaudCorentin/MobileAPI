package com.atlantis.mobile_API;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_devices")
public class User_DeviceController {
    private final User_DeviceRepository user_DeviceRepository;

    public User_DeviceController(User_DeviceRepository user_DeviceRepository){
        this.user_DeviceRepository = user_DeviceRepository;
    }

    @CrossOrigin
    @GetMapping
    public List<User_Device> findAll(){
        return  this.user_DeviceRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/user/{userId}")
    public List<User_Device> findByUserId(@PathVariable Integer userId){
        return this.user_DeviceRepository.findByUserId(userId);
    }
}
