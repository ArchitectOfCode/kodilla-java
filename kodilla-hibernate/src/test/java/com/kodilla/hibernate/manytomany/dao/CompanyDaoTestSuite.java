package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    @Test
    public void testSaveManyToMany(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee mirandaKovalsky = new Employee("Miranda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(mirandaKovalsky);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            System.out.println("Clean up started.");
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
            System.out.println("Clean up finished.");
        } catch (Exception e) {
            System.out.println("Exception during clean up occur: " + e);
        }
    }

    @Test
    public void testNamedQueries() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee mirandaKovalsky = new Employee("Miranda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Masters");
        Company greyMatter = new Company("Grey Matter");
        Company greyLife = new Company("Grey Life");

        softwareMachine.getEmployees().add(johnSmith);
        dataMasters.getEmployees().add(stephanieClarckson);
        dataMasters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);
        greyLife.getEmployees().add(mirandaKovalsky);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        System.out.println("softwareMachineId = " + softwareMachineId);
        companyDao.save(dataMasters);
        int dataMaestersId = dataMasters.getId();
        System.out.println("dataMaestersId = " + dataMaestersId);
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        System.out.println("greyMatterId = " + greyMatterId);
        companyDao.save(greyLife);
        int greyLifeId = greyLife.getId();
        System.out.println("greyLifeId = " + greyLifeId);

        List<Employee> allEmployeesWithNameKovalsky = employeeDao.retrieveEmployeesByLastName("Kovalsky");
        List<Company> companiesWithNamesStartingFor = companyDao.retrieveCompaniesWithNamesStartingFor("Grey");

        //Then
        Assert.assertEquals(1, allEmployeesWithNameKovalsky.size());    // Linda and Miranda Kovalsky
        Assert.assertEquals(1, companiesWithNamesStartingFor.size());

        Assert.assertEquals(2, allEmployeesWithNameKovalsky.size());    // Linda and Miranda Kovalsky
        Assert.assertEquals(2, companiesWithNamesStartingFor.size());

        //CleanUp
        try {
            System.out.println("Clean up started.");
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
            companyDao.delete(greyLifeId);
            System.out.println("Clean up finished.");
        } catch (Exception e) {
            System.out.println("Exception during clean up occur: " + e);
        }
    }
}
