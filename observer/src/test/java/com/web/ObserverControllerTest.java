package com.web;

import org.springframework.web.servlet.ModelAndView;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import junit.framework.Assert;

public class ObserverControllerTest {

	ObserverController controller;
	ModelAndView modelAndView;
	
	@Given("^I have a controller$")
	public void I_have_a_controller() {
		controller = new ObserverController();
	}

	@When("^I receive request$")
	public void I_receive_request() throws Exception {
		modelAndView = controller.handleRequest(null, null);
	}

	@Then("^It belongs to view '([^']*)'$")
	public void It_belongs_to_view(String view) {
		Assert.assertEquals(view, modelAndView.getViewName());
	}
	
	@And("^View has attribute date set$")
	public void View_has_attribute_date_set() {
        Assert.assertNotNull(modelAndView.getModel());
        String nowValue = (String) modelAndView.getModel().get("date");
        Assert.assertNotNull(nowValue);
	}
	
	
		
}
