package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.entity.EmployeeEntity;

@Repository
public class EmployeeDAOWrapperImpl {

	@Autowired
	private EmployeeDAO employeeDao;

	public Integer addEmployee(EmployeeBean employeeBean) throws Exception {
		// TODO Auto-generated method stub
		Integer employeeID = 0;

		EmployeeEntity employeeEntityBean = convertBeanToEntity(employeeBean);
		try {
			employeeEntityBean = employeeDao.save(employeeEntityBean);// insert query

			employeeID = employeeEntityBean.getId();
		} catch (Exception exception) {
			throw exception;
		}

		return employeeID;
	}

	public List<EmployeeBean> getEmployeeList() throws Exception {
		// TODO Auto-generated method stub
		List<EmployeeBean> listEmployeeBean = null;

		try {
			listEmployeeBean = new ArrayList<EmployeeBean>();

			List<EmployeeEntity> listEmployeeEntity = (List<EmployeeEntity>) employeeDao.findAll();

			for (EmployeeEntity entity : listEmployeeEntity) {
				EmployeeBean emp = convertEntityToBean(entity);
				listEmployeeBean.add(emp);
			}

		} catch (Exception exception) {

			throw exception;
		}

		// return employeeEntityBean2;
		return (listEmployeeBean);
	}

	public EmployeeBean getEmployeeDetails(Integer id) throws Exception {
		// TODO Auto-generated method stub
		EmployeeBean employeeBean = null;

		try {

			EmployeeEntity employeeEntity = (EmployeeEntity) employeeDao.findById(id).get();

			if (employeeEntity != null) {
				employeeBean = convertEntityToBean(employeeEntity);
			}

		} catch (Exception exception) {

			throw exception;
		}

		return employeeBean;
	}

	public EmployeeBean updateEmployeeDetails(EmployeeBean employeeBean) throws Exception {
		// TODO Auto-generated method stub
		EmployeeBean employeeBean2 = null;

		try {

			EmployeeEntity employeeEntityBean2 = (EmployeeEntity) (EmployeeEntity) employeeDao
					.findById(employeeBean.getId()).get();

			if (employeeEntityBean2 != null)

			{

				employeeEntityBean2.setInsertTime(employeeBean.getInsertTime());
				employeeEntityBean2.setName(employeeBean.getName());
				employeeEntityBean2.setRole(employeeBean.getRole());
				employeeEntityBean2.setSalary(employeeBean.getSalary());

				employeeDao.save(employeeEntityBean2);
				employeeBean2 = convertEntityToBean(employeeEntityBean2);
			}

		} catch (Exception exception) {

			throw exception;
		}

		return employeeBean2;
	}

	public static EmployeeBean convertEntityToBean(EmployeeEntity entity) {
		EmployeeBean employee = new EmployeeBean();
		BeanUtils.copyProperties(entity, employee);
		return employee;
	}

	public static EmployeeEntity convertBeanToEntity(EmployeeBean bean) {
		EmployeeEntity employeeEntityBean = new EmployeeEntity();
		BeanUtils.copyProperties(bean, employeeEntityBean);
		return employeeEntityBean;
	}

}
