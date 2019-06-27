package com.atlantis.mobile_API;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface User_DeviceRepository extends JpaRepository<User_Device, Long> {
    List<User_Device> findByUserId(Integer userId);
}
