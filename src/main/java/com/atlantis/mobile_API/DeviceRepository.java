package com.atlantis.mobile_API;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByName(String name);
}
