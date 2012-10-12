package com.web;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
	    
	    @RequestMapping(value="/getDefaultCordinate", method = RequestMethod.GET)
		public @ResponseBody Coordinate getDefaultCordinateInJSON() {
	    	
	    	return new Coordinate(-34.9118767, -57.95701059999999); // La Plata
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
	    
	    @RequestMapping(value="/getActivity/{posX}/{posY}/", method = RequestMethod.GET)
		public @ResponseBody Activity getActivity(@PathVariable double posX, @PathVariable double posY) {
	    	
	    	logger.info("PosX: "+roundSixDecimals(posX)+" - PosY: "+roundSixDecimals(posY));
	    	
	    	 Map map = Map.getInstance();
	    	 
	    	 Coordinate coordinate = new Coordinate(posX,posY);
	    	 map.setSearchCoordinates(coordinate);
	    	 
	    	 logger.info("coordinate: "+coordinate.getPosX() +"/"+coordinate.getPosY());
	    	 
	    	 Activity searched_activity = new Activity();
			 
	    	return new Activity();//map.getActivityFromCurrentPosition(searched_activity);
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
	    
	    @RequestMapping(value="/showImageGallery", method = RequestMethod.GET)
        public ModelAndView handleRequestImageGallery(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {            
            return new ModelAndView("showImageGallery");
        }
	    
	    @RequestMapping(value="/showVideoGallery", method = RequestMethod.GET)
        public ModelAndView handleRequestVideoGallery(HttpServletRequest request, HttpServletResponse response)
        		throws ServletException, IOException {
            return new ModelAndView("showVideoGallery");
        }
	    

		private void createMap() {
			//Obtaining a new map instance
	        Map map = Map.getInstance();
	        
	        //Creating coordinates for map
			HashMap<Coordinate, HashSet<Activity>> coordinates = new HashMap<Coordinate,HashSet<Activity>>();
			
			coordinates.put(new Coordinate(-34.912289,-57.957077), new HashSet<Activity>()); //Juan
			coordinates.put(new Coordinate(-34.920273,-57.932541), new HashSet<Activity>()); //Palpa
			coordinates.put(new Coordinate(-34.921769,-57.926146), new HashSet<Activity>()); //Mati
			coordinates.put(new Coordinate(-34.91155,-57.94874), new HashSet<Activity>()); //ACN
			
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
		
		double roundSixDecimals(double d) {
            DecimalFormat sixDForm = new DecimalFormat("#.######");
            return Double.valueOf(sixDForm.format(d));
		}

}
