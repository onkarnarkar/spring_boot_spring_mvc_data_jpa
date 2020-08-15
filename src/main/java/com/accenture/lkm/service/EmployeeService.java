package com.accenture.lkm.service;

import java.util.List;

import com.accenture.lkm.business.bean.EmployeeBean;

public interface EmployeeService {

	Integer addEmployee(EmployeeBean employeeBean) throws Exception;

	List<EmployeeBean> getEmployeeList() throws Exception;

	EmployeeBean getEmployeeDetails(Integer id) throws Exception;

	EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception;

}
