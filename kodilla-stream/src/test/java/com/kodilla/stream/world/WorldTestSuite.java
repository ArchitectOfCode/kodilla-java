package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        List<Country> europeanCountries = new ArrayList<Country>();     // 497518500 citizens
        europeanCountries.add(new Country("Poland", new BigDecimal("38501000")));
        europeanCountries.add(new Country("Russia (european part)", new BigDecimal("103200000")));
        europeanCountries.add(new Country("Romania", new BigDecimal("22247000")));
        europeanCountries.add(new Country("Hungary", new BigDecimal("9931000")));
        europeanCountries.add(new Country("Great Britain", new BigDecimal("60944000")));
        europeanCountries.add(new Country("Italy", new BigDecimal("58145000")));
        europeanCountries.add(new Country("Slovakia", new BigDecimal("5455000")));
        europeanCountries.add(new Country("Slovenia", new BigDecimal("2007000")));
        europeanCountries.add(new Country("Czech Republic", new BigDecimal("10221000")));
        europeanCountries.add(new Country("Spain", new BigDecimal("40491000")));
        europeanCountries.add(new Country("Kazakhstan (european part)", new BigDecimal("1300000")));
        europeanCountries.add(new Country("Germany", new BigDecimal("82370000")));
        europeanCountries.add(new Country("France", new BigDecimal("62151000")));
        europeanCountries.add(new Country("Transnistria", new BigDecimal("555500")));

        List<Country> asianCountries = new ArrayList<Country>();        // 3323200000 citizens
        asianCountries.add(new Country("China", new BigDecimal("1373500000")));
        asianCountries.add(new Country("India", new BigDecimal("1266900000")));
        asianCountries.add(new Country("Pakistan", new BigDecimal("202000000")));
        asianCountries.add(new Country("Bangladesh", new BigDecimal("156200000")));
        asianCountries.add(new Country("Japan", new BigDecimal("126700000")));
        asianCountries.add(new Country("Philippines", new BigDecimal("102600000")));
        asianCountries.add(new Country("Vietnam", new BigDecimal("95300000")));

        List<Country> africanCountries = new ArrayList<Country>();      // 459737465 citizens
        africanCountries.add(new Country("Nigeria",new BigDecimal("186100000")));
        africanCountries.add(new Country("Ethiopia",new BigDecimal("102400000")));
        africanCountries.add(new Country("Egipt",new BigDecimal("94700000")));
        africanCountries.add(new Country("Algeria",new BigDecimal("34994937")));
        africanCountries.add(new Country("Burkina Faso",new BigDecimal("16751455")));
        africanCountries.add(new Country("Ghana",new BigDecimal("24791073")));


        List<Continent> continentList = new ArrayList<Continent>();     // 4280455965 citizens
        continentList.add(new Continent("Europe", europeanCountries));
        continentList.add(new Continent("Asia", asianCountries));
        continentList.add(new Continent("Africa", africanCountries));


        World world = new World(continentList);

        BigDecimal overallNumberOfPeople = world.getPeopleQuantity();
        BigDecimal expectedOverallNumberOfPeople = new BigDecimal("4280455965");
        Assert.assertEquals(expectedOverallNumberOfPeople, overallNumberOfPeople);
    }

    @Test
    public void testGetAllCountries() {
        List<Country> europeanCountries = new ArrayList<Country>();     // 497518500 citizens
        europeanCountries.add(new Country("Poland", new BigDecimal("38501000")));
        europeanCountries.add(new Country("Russia (european part)", new BigDecimal("103200000")));
        europeanCountries.add(new Country("Romania", new BigDecimal("22247000")));
        europeanCountries.add(new Country("Hungary", new BigDecimal("9931000")));
        europeanCountries.add(new Country("Great Britain", new BigDecimal("60944000")));
        europeanCountries.add(new Country("Italy", new BigDecimal("58145000")));
        europeanCountries.add(new Country("Slovakia", new BigDecimal("5455000")));
        europeanCountries.add(new Country("Slovenia", new BigDecimal("2007000")));
        europeanCountries.add(new Country("Czech Republic", new BigDecimal("10221000")));
        europeanCountries.add(new Country("Spain", new BigDecimal("40491000")));
        europeanCountries.add(new Country("Kazakhstan (european part)", new BigDecimal("1300000")));
        europeanCountries.add(new Country("Germany", new BigDecimal("82370000")));
        europeanCountries.add(new Country("France", new BigDecimal("62151000")));
        europeanCountries.add(new Country("Transnistria", new BigDecimal("555500")));

        List<Country> asianCountries = new ArrayList<Country>();        // 3323200000 citizens
        asianCountries.add(new Country("China", new BigDecimal("1373500000")));
        asianCountries.add(new Country("India", new BigDecimal("1266900000")));
        asianCountries.add(new Country("Pakistan", new BigDecimal("202000000")));
        asianCountries.add(new Country("Bangladesh", new BigDecimal("156200000")));
        asianCountries.add(new Country("Japan", new BigDecimal("126700000")));
        asianCountries.add(new Country("Philippines", new BigDecimal("102600000")));
        asianCountries.add(new Country("Vietnam", new BigDecimal("95300000")));

        List<Country> africanCountries = new ArrayList<Country>();      // 459737465 citizens
        africanCountries.add(new Country("Nigeria",new BigDecimal("186100000")));
        africanCountries.add(new Country("Ethiopia",new BigDecimal("102400000")));
        africanCountries.add(new Country("Egipt",new BigDecimal("94700000")));
        africanCountries.add(new Country("Algeria",new BigDecimal("34994937")));
        africanCountries.add(new Country("Burkina Faso",new BigDecimal("16751455")));
        africanCountries.add(new Country("Ghana",new BigDecimal("24791073")));


        List<Continent> continentList = new ArrayList<Continent>();     // 4280455965 citizens
        continentList.add(new Continent("Europe", europeanCountries));
        continentList.add(new Continent("Asia", asianCountries));
        continentList.add(new Continent("Africa", africanCountries));


        World world = new World(continentList);

        int expectecNumberOfCountries = 27;

        Assert.assertEquals(expectecNumberOfCountries, world.getAllCountries().size());

        for(Country country : world.getAllCountries()) {
            System.out.println(country.getCountryName());
        }
    }
}
