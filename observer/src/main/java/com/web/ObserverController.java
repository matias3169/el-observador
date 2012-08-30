package com.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ObserverController {

	    protected final Log logger = LogFactory.getLog(getClass());

	    @RequestMapping(value="/showMap.htm")
	    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        logger.info("Returning showMap view");

	        String now = (new Date()).toString();

	        return new ModelAndView("showMap", "date", now);
	    }

	
}
