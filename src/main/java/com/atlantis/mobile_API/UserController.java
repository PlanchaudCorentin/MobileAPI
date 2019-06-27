package com.atlantis.mobile_API;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    private final DeviceRepository deviceRepository;
    private final User_DeviceRepository user_deviceRepository;

    public UserController(UserRepository userRepository, DeviceRepository deviceRepository, User_DeviceRepository user_deviceRepository){
        this.userRepository = userRepository;
        this.deviceRepository = deviceRepository;
        this.user_deviceRepository = user_deviceRepository;
    }

    @CrossOrigin
    @GetMapping
    public List<User> findAll(){
        return this.userRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/id/{id}")
    public User findById(@PathVariable Long id) {
        return this.userRepository.findById(id).get();
    }

    @CrossOrigin
    @GetMapping("/mail/{mail}")
    public User findByName(@PathVariable String mail) {
        return this.userRepository.findByMail(mail);
    }

    @CrossOrigin
    @GetMapping("/devices/{id}")
    public List<Device> findDevicesByUserId(@PathVariable Integer id){

        List<User_Device> relationList = this.user_deviceRepository.findByUserId(id);

        List<Device> devicesList = new ArrayList<>();

        for (User_Device relation: relationList
             ) {
            long deviceId = relation.getDeviceId();
            devicesList.add(this.deviceRepository.findById(deviceId).get());
        }

        return devicesList;

    }

    @CrossOrigin
    @GetMapping("/devicesbymail/{mail}")
    public List<Device> findDevicesByUserMail(@PathVariable String mail){
        User askedUser = this.userRepository.findByMail(mail);

        List<User_Device> relationList = this.user_deviceRepository.findByUserId((int)askedUser.getId());

        List<Device> devicesList = new ArrayList<>();

        for (User_Device relation: relationList
        ) {
            long deviceId = relation.getDeviceId();
            devicesList.add(this.deviceRepository.findById(deviceId).get());
        }

        return devicesList;

    }
}
