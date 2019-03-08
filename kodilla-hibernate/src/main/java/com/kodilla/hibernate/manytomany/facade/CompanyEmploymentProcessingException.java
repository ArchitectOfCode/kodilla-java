package com.kodilla.hibernate.manytomany.facade;

public class CompanyEmploymentProcessingException extends Exception {
    public static String ERR_COMPANY_NOT_FOUND = "Company has not been found";
    public static String ERR_EMPLOYEE_NOT_FOUND = "Employee has not been found";

    public CompanyEmploymentProcessingException(String message) {
        super(message);
    }
}
