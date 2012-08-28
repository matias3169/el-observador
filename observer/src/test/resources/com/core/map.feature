Feature: Get activities for a position
		 In order to view activities
		 As a user
		 I want to get activities for a position
		  
	Scenario: Map can return activities
		Given I have a map
		And Map has coordinates
		And Coordinates have activities
		When I give positionX 0 positionY 0 to Map 
		Then I can get list of activities for that position
	
	Scenario: Map has not got activities
		Given I have a map
		And Map has coordinates
		When I give positionX 0 positionY 0 to Map 
		Then I get empty list of activities for that position

	Scenario: Map for a specific position has an activity
		Given I have a map
		And Map has coordinates
		And Coordinates have activities
		When I give positionX 0 positionY 0 to Map
		And I choose activity 1 
		Then I get details from activity	