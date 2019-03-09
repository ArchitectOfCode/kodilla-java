package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyEmployeeTestSuite {
    @Autowired
    CompanyEmploymentFacade companyEmploymentFacade;

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testEmployeeFacade() throws CompanyEmploymentProcessingException{
        // Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee mirandaKovalsky = new Employee("Miranda", "Kovalsky");

        employeeDao.save(johnSmith);
        employeeDao.save(stephanieClarckson);
        employeeDao.save(lindaKovalsky);
        employeeDao.save(mirandaKovalsky);

        // When
        List<Employee> allEmployeesWithNameContainVals = companyEmploymentFacade.retrieveEmployeesByLastNameLike("vals");
        List<Employee> allEmployeesWithNameContainClarck = companyEmploymentFacade.retrieveEmployeesByLastNameLike("Clarck");

        //Then
        Assert.assertEquals(2, allEmployeesWithNameContainVals.size());
        Assert.assertEquals(1, allEmployeesWithNameContainClarck.size());

        // Clean up
        employeeDao.deleteAll();
    }

    @Test
    public void testCompanyFacade() throws CompanyEmploymentProcessingException{
        // Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");
        Company greyLife = new Company("Grey Life");

        companyDao.save(softwareMachine);
        companyDao.save(dataMasters);
        companyDao.save(greyMatter);
        companyDao.save(greyLife);

        // When
        List<Company> allCompaniesWithNameContainRey = companyEmploymentFacade.retrieveCompaniesWithNameLike("rey");
        List<Company> allCompaniesWithNameContainTt = companyEmploymentFacade.retrieveCompaniesWithNameLike("tt");

        // Then
        Assert.assertEquals(2, allCompaniesWithNameContainRey.size());
        Assert.assertEquals(1, allCompaniesWithNameContainTt.size());

        // Clean up
        companyDao.deleteAll();
    }
}
