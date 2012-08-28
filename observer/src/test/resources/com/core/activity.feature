Feature: Get the audio's gallery for an activity
		 In order to view the audio's gallery
		 As a user
		 I want to get the audio's gallery for an activity
		  
	Scenario: Activity can return an audio's gallery
		Given I have an activity
		And Activity has an audio's gallery
		When I select the audio's gallery 
		Then I can get the audio's gallery 