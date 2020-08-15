package com.accenture.lkm.dao;

import org.springframework.data.repository.CrudRepository;

import com.accenture.lkm.entity.EmployeeEntity;

public interface EmployeeDAO extends CrudRepository<EmployeeEntity, Integer> {

}