package com.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.core.Activity;
import com.core.Coordinate;
import com.core.Map;

@Controller
public class ObserverController {

	    protected final Log logger = LogFactory.getLog(getClass());

	    @RequestMapping(value="/showMap.htm", method = RequestMethod.GET)
	    public ModelAndView handleRequestShowMap(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        logger.info("Returning showMap view");

	        String now = (new Date()).toString();

	        return new ModelAndView("showMap", "date", now);
	    }

	    @RequestMapping(value="/showActivities.htm", method = RequestMethod.GET)
	    public ModelAndView handleRequestShowActivities(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        logger.info("Entering showActivities handler");
	        
	        //Obtaining a new map instance
	        Map map = Map.getInstance();
	        
	        //Creating coordinates for map
			HashMap<Coordinate, HashSet<Activity>> coordinates = new HashMap<Coordinate,HashSet<Activity>>();
			coordinates.put(new Coordinate(0,0), new HashSet<Activity>());
			coordinates.put(new Coordinate(10,10), new HashSet<Activity>());
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
		    
		    //Obtaining positions from map
	        int coordenadaX = Integer.parseInt(request.getParameter("coordenadaX").toString());
	        int coordenadaY = Integer.parseInt(request.getParameter("coordenadaY").toString());
	        
		    //Setting search coordinates	        
	        map.setSearchCoordinates(new Coordinate(coordenadaX, coordenadaY));
	        
	        ModelAndView result = new ModelAndView("showActivities");
		    //Obtaining list of activities
	        result.addObject("activities", map.getListOfActivitiesFromCurrentPosition());
	        
	        return result;
	    }

}
