package com.example.lab8;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest() {
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void testHasCity() {
        CustomList list = MockCityList();

        City cityNotInList = new City("Calgary", "Alberta");
        assertFalse("City should not be in the list initially", list.hasCity(cityNotInList));

        list.addCity(cityNotInList);
        assertTrue("City should be in the list after being added", list.hasCity(cityNotInList));
    }

    @Test
    public void testDeleteCityExists() {
        CustomList list = MockCityList();
        City city = new City("Calgary", "Alberta");
        list.addCity(city);
        assertTrue("City should be in the list before deletion", list.hasCity(city));
        list.delete(city);
        assertFalse("City should not be in the list after deletion", list.hasCity(city));
    }

    @Test
    public void testCountCitiesEmpty() {
        list = MockCityList();
        assertEquals(0, list.getCount(), "Count should be 0 for an empty list");

        City city = new City("Calgary", "Alberta");
        list.addCity(city);
        assertEquals(1, list.getCount(), "Count should be 1 when there is one city in the list");

        list.addCity(new City("Toronto", "Alberta"));
        assertEquals(2, list.getCount(), "Count should be 2 when there are two cities in the list");

        list.delete(city);
        assertEquals(1, list.getCount(), "Count should be 1 after deleting a city from the list");
    }

}