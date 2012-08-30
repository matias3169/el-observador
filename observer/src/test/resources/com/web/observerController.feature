Feature: Do correct redirection
		 In order to access web resources
		 As a user
		 I want observerController to redirect according to request
		  
	Scenario: Controller can redirect to asked request
		Given I have a controller
		When I receive request 
		Then It belongs to view 'showMap'
		And View has attribute date set