package com.main;

import org.omg.CORBA.portable.ApplicationException;

import java.util.Map;

public interface EmployeeForm extends EmployeeOutsource {

    Map<String, String> employeeData(String data)throws ApplicationException;

}
