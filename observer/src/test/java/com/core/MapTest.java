package com.core;

import java.util.HashMap;
import java.util.HashSet;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.junit.Assert;


public class MapTest {

	  private Map map;
	  private Activity activity;
	  private static final int TESTID = 1;
	  private static final String TESTDESCRIPTION = "Activity1";
	  HashMap<Coordinate,HashSet<Activity>> coordinates;
	  
	  @Given("^I have a map$")
	  public void I_have_a_map() {
	    map = Map.getInstance();
	  }

	  @And("^Map has coordinates$")
	  public void Map_has_coordinates() {
		coordinates = new HashMap<Coordinate,HashSet<Activity>>();
				
		coordinates.put(new Coordinate(0,0), new HashSet<Activity>());
		coordinates.put(new Coordinate(10,10), new HashSet<Activity>());
		
	    map.setCoordinates(coordinates);

	  }
	  
	  @And("^Coordinates have activities$")
	  public void Coordinates_have_activities() {
		HashSet<Activity>  activities = new HashSet<Activity>();
		
		Activity temp_activity = new Activity();
		temp_activity.setId(TESTID);
		temp_activity.setDescription(TESTDESCRIPTION);
	    activities.add(temp_activity);
	    activities.add(new Activity());
	    
	    coordinates = map.getCoordinates();
	    
	    for (Coordinate coord : coordinates.keySet()) {
	    	coordinates.put(coord, activities);
		}
	    
	  }

	  @When("^I give positionX (\\d+) positionY (\\d+) to Map$")
	  public void I_give_coordinates(double posX, double posY) {
		 Coordinate coordinate = new Coordinate(posX,posY);
	     map.setSearchCoordinates(coordinate);
	  }
	  
	  @And("^I choose activity (\\d+)$")
	  public void I_choose_activity(int activityID) {
		 Activity searched_activity = new Activity();
		 searched_activity.setId(activityID);
		 this.activity = map.getActivityFromCurrentPosition(searched_activity);
	  }

	  @Then("^I can get list of activities for that position$")
	  public void I_Can_Get_List_Of_Activities() {
		  Assert.assertFalse(map.getListOfActivitiesFromCurrentPosition().isEmpty());
	  }

	  @Then("^I get empty list of activities for that position$") 
	  public void I_Get_Empty_List_Of_Activities() {
		  Assert.assertTrue(map.getListOfActivitiesFromCurrentPosition().isEmpty());
	  }
	  
	  @Then("^I get details from activity") 
	  public void I_Get_Details_From_Activity() {
		  Assert.assertEquals(TESTID,this.activity.getId());
		  Assert.assertEquals(TESTDESCRIPTION,this.activity.getDescription());
	  }
	  
	  

}
