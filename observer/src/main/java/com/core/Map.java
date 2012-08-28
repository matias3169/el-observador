package com.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

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

	public HashSet<Activity> getListOfActivitiesFromCurrentPosition(){		
		return coordinates.get(search_coordinate);
	}

	public Activity getActivityFromCurrentPosition(Activity activity) {

		Iterator<Activity> it = getListOfActivitiesFromCurrentPosition().iterator();
		Activity it_activity = null;
		boolean found = false;
		
		while (it.hasNext() && (found == false)) {
			it_activity = (Activity) it.next();
			
			if (it_activity.equals(activity)){
				found = true;
			}	
		}
		
		return it_activity;
	}

}
