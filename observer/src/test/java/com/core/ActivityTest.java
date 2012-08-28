package com.core;

import java.util.HashSet;

import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.junit.Assert;

public class ActivityTest {
	
	Activity anAntivity;
	HashSet<Audio> audioGallery;
	
	@Given("^I have an activity$")
	public void I_have_an_activity() {
	    // Express the Regexp above with the code you wish you had
	    anAntivity = new Activity();
	}

	@Given("^Activity has an audio's gallery$")
	public void Activity_has_an_audio_s_gallery() {
	    // Express the Regexp above with the code you wish you had
	    HashSet<Audio> audioGallery = new HashSet<Audio>();
	    anAntivity.setAudioGallery(audioGallery);
	}

	@When("^I select the audio's gallery$")
	public void I_select_the_audio_s_gallery() {
	    // Express the Regexp above with the code you wish you had
		audioGallery = anAntivity.getAudioGallery();
	}

	@Then("^I can get the audio's gallery$")
	public void I_can_get_the_audio_s_gallery() {
	    // Express the Regexp above with the code you wish you had
		Assert.assertTrue(this.audioGallery.isEmpty());
	}

}
