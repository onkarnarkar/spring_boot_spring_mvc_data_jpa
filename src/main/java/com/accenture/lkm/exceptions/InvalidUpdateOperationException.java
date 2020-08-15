package com.accenture.lkm.exceptions;

@SuppressWarnings("serial")
public class InvalidUpdateOperationException extends Exception {
	public InvalidUpdateOperationException() {
		super("Entered EmployeeId doesn't exist, Please give a valid employeeId");
	}

}
