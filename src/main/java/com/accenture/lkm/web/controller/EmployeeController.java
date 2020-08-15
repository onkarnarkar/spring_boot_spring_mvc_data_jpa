package com.accenture.lkm.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.EmployeeBean;
import com.accenture.lkm.exceptions.InvalidUpdateOperationException;
import com.accenture.lkm.service.EmployeeService;

@Controller
@SuppressWarnings("unused")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// https://stackoverflow.com/questions/20616319/the-request-sent-by-the-client-was-syntactically-incorrect-spring-mvc-jdbc-te
	// this is required to share the date for update on multiple submissions
	// otherwise Spring will not know how to parse date from date to String and vice
	// versa
	// in subsequent request submissions
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

		binder.registerCustomEditor(Date.class, "insertTime", new CustomDateEditor(sdf, true));
	}

	// Default method is Get
	@RequestMapping("/")
	public ModelAndView showRegistrationPage() {
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/GetDetails", method = RequestMethod.GET)
	public ModelAndView getAllEmployees() throws Exception {

		List<EmployeeBean> list = employeeService.getEmployeeList();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GetAllEmployeeDetails");
		modelAndView.addObject("empList", list);
		return modelAndView;

	}


	// save
	@RequestMapping(value = "/LoadSaveEmployee", method = RequestMethod.GET)
	public ModelAndView loadSaveEmployee() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CreateEmployee");
		modelAndView.addObject("empObj", new EmployeeBean());
		return modelAndView;

	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("empObj") EmployeeBean EmployeeBean) throws Exception {
		int i = employeeService.addEmployee(EmployeeBean);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("CreateEmployeeSuccess");
		modelAndView.addObject("message", "EmployeeBean add successfully with id: " + i);
		return modelAndView;
	}

	@RequestMapping(value = "/LoadUpdateEmployee", method = RequestMethod.GET)
	public ModelAndView loadUpdateEmployee1() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdateEmployee");
		modelAndView.addObject("empObj", new EmployeeBean());
		return modelAndView;
	}

	@RequestMapping(value = "/LoadUpdateEmployee2", method = RequestMethod.POST)
	public ModelAndView loadUpdateEmployee2(@ModelAttribute("empObj") EmployeeBean EmployeeBean) throws Exception {

		EmployeeBean employee2 = employeeService.getEmployeeDetails(EmployeeBean.getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdateEmployee");
		modelAndView.addObject("empObj2", employee2);
		return modelAndView;
	}

	// UpdateEmployee
	@RequestMapping(value = "/UpdateEmployee", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("empObj2") EmployeeBean EmployeeBean, Model model)
			throws Exception {
		EmployeeBean employee2 = employeeService.updateEmployeeDetails(EmployeeBean);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("UpdateEmployeeSuccess");
		return modelAndView;
	}

	@ExceptionHandler(value = InvalidUpdateOperationException.class)
	public ModelAndView handleInvalidUpdateOperationException(InvalidUpdateOperationException exception) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		modelAndView.setViewName("ExceptionHandlerPage");
		return modelAndView;
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleAllExceptions(Exception exception) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GeneralizedExceptionHandlerPage");
		modelAndView.addObject("message", exception.getMessage());
		modelAndView.addObject("exception", exception);
		return modelAndView;
	}

}
