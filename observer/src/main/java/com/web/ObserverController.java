package com.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.core.Activity;
import com.core.Coordinate;
import com.core.Map;

@Controller
public class ObserverController {

	    protected final Log logger = LogFactory.getLog(getClass());

	    @RequestMapping(value="/showMap", method = RequestMethod.GET)
	    public ModelAndView handleRequestShowMap(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	    	createMap();
	    	
	        logger.info("Returning showMap view");

	        String now = (new Date()).toString();

	        return new ModelAndView("showMap", "date", now);
	    }
	    
	    @RequestMapping(value="/getCordinates/{id}", method = RequestMethod.GET)
		public @ResponseBody Set<Coordinate> getCordinatesInJSON(@PathVariable int id) {
	    	
	    	logger.info("Id: "+id);
	 
	    	//Obtaining a new map instance
	        Map map = Map.getInstance();
	      
//	    	List<Coordinate> coordinates = new ArrayList<Coordinate>();
//			coordinates.add(new Coordinate(0,0));
//			coordinates.add(new Coordinate(10,10));
			
			return map.getCoordinates().keySet();
		}

	    @RequestMapping(value="/showActivities.htm", method = RequestMethod.GET)
	    public ModelAndView handleRequestShowActivities(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        logger.info("Entering showActivities handler");
	        
//	        Map map = createMap();
//		    
//		    //Obtaining positions from map
//	        int coordenadaX = Integer.parseInt(request.getParameter("coordenadaX").toString());
//	        int coordenadaY = Integer.parseInt(request.getParameter("coordenadaY").toString());
//	        
//		    //Setting search coordinates	        
//	        map.setSearchCoordinates(new Coordinate(coordenadaX, coordenadaY));
//	        
//	        ModelAndView result = new ModelAndView("showActivities");
//		    //Obtaining list of activities
//	        result.addObject("activities", map.getListOfActivitiesFromCurrentPosition());
//	        
	        return null;
	    }

		private void createMap() {
			//Obtaining a new map instance
	        Map map = Map.getInstance();
	        
	        //Creating coordinates for map
			HashMap<Coordinate, HashSet<Activity>> coordinates = new HashMap<Coordinate,HashSet<Activity>>();
			coordinates.put(new Coordinate(0,0), new HashSet<Activity>());
			coordinates.put(new Coordinate(10,10), new HashSet<Activity>());
			coordinates.put(new Coordinate(60,100), new HashSet<Activity>());
		    map.setCoordinates(coordinates);
		    
	        //Creating activities for coordinates		    
			HashSet<Activity>  activities = new HashSet<Activity>();			
			Activity temp_activity = new Activity();
			temp_activity.setId(1);
			temp_activity.setDescription("Actividad1");
		    activities.add(temp_activity);
		    
		    //Setting activities to coordinates
		    coordinates = map.getCoordinates();
		    
		    for (Coordinate coord : coordinates.keySet()) {
		    	coordinates.put(coord, activities);
			}
		}

}
