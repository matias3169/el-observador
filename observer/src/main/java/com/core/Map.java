package com.core;

import java.util.HashMap;
import java.util.HashSet;

public class Map {

	private HashMap<Coordinate,HashSet<Activity>> coordinates;
	private Coordinate search_coordinate;
	
	public void setSearchCoordinates(Coordinate coordinate) {
		search_coordinate = coordinate;		
	}

	public void setCoordinates(HashMap<Coordinate,HashSet<Activity>> coordinates) {
		this.coordinates = coordinates;		
	}

	public HashMap<Coordinate,HashSet<Activity>> getCoordinates() {
		return coordinates;
	}

	public HashSet<Activity> getListOfActivitiesFromCurrentPosition() {		
		return coordinates.get(search_coordinate);

	}

}
