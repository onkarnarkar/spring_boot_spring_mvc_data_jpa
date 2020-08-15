package com.accenture.lkm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.dao.EmployeeDAOWrapperImpl;
import com.accenture.lkm.exceptions.InvalidUpdateOperationException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAOWrapperImpl employeeDAOWrapperImpl;

	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		return employeeDAOWrapperImpl.addEmployee(employeeBean);
	}

	public List<EmployeeBean> getEmployeeList() throws Exception {

		return employeeDAOWrapperImpl.getEmployeeList();
	}

	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception {
		EmployeeBean emp = employeeDAOWrapperImpl.updateEmployeeDetails(employeeBean);
		return emp;
	}

	public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
		EmployeeBean emp = employeeDAOWrapperImpl.getEmployeeDetails(id);
		if (emp == null) {
			throw new InvalidUpdateOperationException();
		}
		return emp;
	}

}
