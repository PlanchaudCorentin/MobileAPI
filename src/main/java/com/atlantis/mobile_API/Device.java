package com.atlantis.mobile_API;

import javax.persistence.*;

@Entity
@Table(name = "device", schema = "metrics_db")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }

    @Column(name="name")
    private String name;

    @Column(name = "mac_address")
    private String mac_address;

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mac_address='" + mac_address + '\'' +
                '}';
    }
}
