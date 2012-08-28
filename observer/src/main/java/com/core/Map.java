package com.core;

import java.util.HashMap;
import java.util.HashSet;

public class Map {

	private static Map map;
	private static boolean exists = false;
	private HashMap<Coordinate,HashSet<Activity>> coordinates;
	private Coordinate search_coordinate;
	
	private Map(){
    }
	 
    public static Map getInstance() 
    {
	    if(exists == false) {
	        map = new Map();
	        exists = true;
	    }
	    
	    return map;
    }
    
	public void setSearchCoordinates(Coordinate coordinate) {
		search_coordinate = coordinate;		
	}
	
	public Coordinate getSearchCoordinates() {
		return search_coordinate;		
	}

	public void setCoordinates(HashMap<Coordinate,HashSet<Activity>> coordinates) {
		this.coordinates = coordinates;		
	}

	public HashMap<Coordinate,HashSet<Activity>> getCoordinates() {
		return coordinates;
	}

	public HashSet<Activity> getListOfActivitiesFromCurrentPosition() throws Exception{
		
		HashSet<Activity> temp_activities = coordinates.get(search_coordinate);
		
		if (temp_activities == null) {
			throw new Exception("There are no activities in coordinate - PosX:" + search_coordinate.getPosX() + " PosY:" + search_coordinate.getPosY());
		} 
		
		return temp_activities;

	}

}
