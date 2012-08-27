Feature: Get activities from a position

Scenario: Map can return activities
Given I have a map
Given Map has coordinates
Given Coordinates have activities
When I give positionX 0 positionY 0 to Map 
Then I can get list of activities from that position