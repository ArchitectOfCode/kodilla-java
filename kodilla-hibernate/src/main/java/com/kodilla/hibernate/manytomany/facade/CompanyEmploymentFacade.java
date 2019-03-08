package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyEmploymentFacade {
    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyEmploymentFacade.class);

    public List<Employee> retrieveEmployeesByLastNameLike(final String lastName) throws CompanyEmploymentProcessingException {
        LOGGER.info("Looking for employees with name like '" + lastName + "'");
        List<Employee> employeesFound = employeeDao.retrieveEmployeesByLastNameLike(lastName);
        int numEmployeesFound = employeesFound.size();
        if(numEmployeesFound == 0) {
            LOGGER.error(CompanyEmploymentProcessingException.ERR_EMPLOYEE_NOT_FOUND);
            throw new CompanyEmploymentProcessingException(CompanyEmploymentProcessingException.ERR_EMPLOYEE_NOT_FOUND);
        } else if(numEmployeesFound == 1) {
            LOGGER.info("One employee with name like " + lastName + " has been found: " + employeesFound.get(0));
            return employeesFound;
        } else {
            LOGGER.info(numEmployeesFound + " employees with name like '" + lastName + "' have been found:");
            //employeesFound.forEach(employee -> LOGGER.info(employee.getFirstName() + " " + employee.getLastName()));
            return employeesFound;
        }
    }

    public List<Company> retrieveCompaniesWithNameLike(final String name) throws CompanyEmploymentProcessingException {
        LOGGER.info("Looking for companies with name like '" + name + "'");
        List<Company> companiesFound = companyDao.retrieveCompaniesWithNameLike(name);
        int numCompaniesFound = companiesFound.size();
        if(numCompaniesFound == 0) {
            LOGGER.error(CompanyEmploymentProcessingException.ERR_COMPANY_NOT_FOUND);
            throw new CompanyEmploymentProcessingException(CompanyEmploymentProcessingException.ERR_COMPANY_NOT_FOUND);
        } else if(numCompaniesFound == 1) {
            LOGGER.info("One company with name like " + name + " has been found: " + companiesFound.get(0));
            return companiesFound;
        } else {
            LOGGER.info(numCompaniesFound + " companies with name like '" + name + "' have been found:");

            //companiesFound.forEach(company -> LOGGER.info(company.getName()));
            /*for(Company company : companiesFound) {
                LOGGER.info(company.getName());
            }*/

            return companiesFound;
        }
    }
}
