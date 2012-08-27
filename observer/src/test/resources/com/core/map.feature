Feature: Get activities for a position

	Scenario: Map can return activities
		Given I have a map
		Given Map has coordinates
		Given Coordinates have activities
		When I give positionX 0 positionY 0 to Map 
		Then I can get list of activities for that position
	
	Scenario: Map has not got activities
		Given I have a map
		Given Map has coordinates
		When I give positionX 0 positionY 0 to Map 
		Then I get message No activities for that position
	