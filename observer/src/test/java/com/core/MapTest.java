package com.core;

import java.util.HashMap;
import java.util.HashSet;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.junit.Assert;


public class MapTest {

	  private Map map;
	  HashMap<Coordinate,HashSet<Activity>> coordinates;
	  
	  @Given("^I have a map")
	  public void I_have_a_map() {
	    map = new Map();
	  }

	  @Given("Map has coordinates")
	  public void Map_has_coordinates() {
		coordinates = new HashMap<Coordinate,HashSet<Activity>>();
				
		coordinates.put(new Coordinate(0,0), null);
		coordinates.put(new Coordinate(10,10), null);
		
	    map.setCoordinates(coordinates);

	  }
	  
	  @Given("Coordinates have activities")
	  public void Coordinates_have_activities() {
		HashSet<Activity>  activities = new HashSet<Activity>();
	    activities.add(new Activity());
	    activities.add(new Activity());
	    
	    coordinates = map.getCoordinates();
	    
	    for (Coordinate coord : coordinates.keySet()) {
	    	coordinates.put(coord, activities);
		}
	    
	  }

	  @When("I give positionX (\\d+) positionY (\\d+) to Map")
	  public void I_give_coordinates(int posX, int posY) {
		 Coordinate coordinate = new Coordinate(posX,posY);
	     map.setSearchCoordinates(coordinate);
	  }

	  @Then("I can get list of activities for that position$")
	  public void I_Can_Get_List_Of_Activities() {
	    try {
			Assert.assertFalse(map.getListOfActivitiesFromCurrentPosition().isEmpty());
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }

	  @Then("I get message No activities for that position$") 
	  public void I_Print_No_Activities_Message() {
	    try {
			map.getListOfActivitiesFromCurrentPosition();
		} catch (Exception e) {
			Assert.assertEquals("There are no activities in coordinate - PosX:" + map.getSearchCoordinates().getPosX() +" PosY:"+ map.getSearchCoordinates().getPosY(), e.getMessage());
		}
	  }

}
