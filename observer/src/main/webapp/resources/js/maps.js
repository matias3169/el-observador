//--------------------------------------------------------------------------------
//			
//
//			Scripts correspondientes a la funcionalidad de los mapas
//
//
//--------------------------------------------------------------------------------

//Includes de otras paginas JS que se utilizan
document.write("<script type='text/javascript' src='resources/js/scripts.js'></script>");

 
//Variables generales
var MAP;
var IMAGE_ACTIVITY = "resources/img/activity.png";
var MYPLACE = new google.maps.Circle();
var MYPLACE_ACTIVE=0;
var POSITION;

//--------------------------------------------------------
//
//Funciona llamada para inicializar el mapa
//
//--------------------------------------------------------
$(document).ready(function(){
	
	$.getJSON("getCordinates/1", function(json) {
    	console.log(json);
	});
	//getCurrentLocation();
	//Se crea una variable con la latitud y la longitud
	var latlng = new google.maps.LatLng(-34.9118767, -57.95701059999999);
    
	//Se setean las configuraciones del mapa
	var myOptions = {
      zoom: 13,
      disableDefaultUI: true,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.TERRAIN
    };
    
	//Se crea el mapa en el elemento con id "map_canvas" con las opciones indicadas
    MAP = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    
    //Se agrega un listener al evento click en el mapa
    google.maps.event.addListener(MAP, 'click', function(event) {
    	placeMarker(event.latLng);
      });
	
});
 
//-----------------------------------------------------------------------------------
//Descripcion: Funcion para colocar un marcador en el mapa
//
//Parametros
//	        IN-location: ubicacion en el mapa (latitud, longitud)
//-----------------------------------------------------------------------------------
function placeMarker(location)
{

//Creamos la imagen a mostrar	
var image = new google.maps.MarkerImage(IMAGE_ACTIVITY, new google.maps.Size(50, 80),
			 						    new google.maps.Point(0,0),new google.maps.Point(0, 32));
	
//configuramos el marker	
var marker = new google.maps.Marker({
	      position: location,
	      icon: IMAGE_ACTIVITY,
	      map: MAP
	  });

//Agregamos el listener al marker
google.maps.event.addListener(marker, 'click', function() { showActivity();});
		
}

//function ShowMyPlaces()
//{
//	if(MYPLACE_ACTIVE == 1)
//	{
//		alert("lo activo");
//		MYPLACE_ACTIVE=0;
//		
//		
////		var populationOptions = {
////	      strokeColor: "#FF0000",
////	      strokeOpacity: 0.8,
////	      strokeWeight: 2,
////	      fillColor: "#FF0000",
////	      fillOpacity: 0.35,
////	      map: MAP,
////	      center: new google.maps.LatLng(-34.9118767, -57.95701059999999),
////	      radius: 1000
////	    };
////
////		MYPLACE = new google.maps.Circle(populationOptions);
//	}
//	else
//	{
//		alert("lo desactivo");
//		MYPLACE_ACTIVE=1;
////		MYPLACE.setMap(null);
//	}
//
//}







//Note that using Google Gears requires loading the Javascript
//at http://code.google.com/apis/gears/gears_init.js

var initialLocation;
var siberia = new google.maps.LatLng(60, 105);
var newyork = new google.maps.LatLng(40.69847032728747, -73.9514422416687);
var browserSupportFlag =  new Boolean();

function getCurrentLocation()
{

// Try W3C Geolocation (Preferred)
if(navigator.geolocation)
{
	browserSupportFlag = true;
	navigator.geolocation.getCurrentPosition(function(position) {
	POSITION = new google.maps.LatLng(position.coords.latitude,position.coords.longitude);
	//map.setCenter(initialLocation);
	}, function() {  handleNoGeolocation(browserSupportFlag); });
// Try Google Gears Geolocation
}
else if (google.gears)
		{
			browserSupportFlag = true;
			var geo = google.gears.factory.create('beta.geolocation');
			geo.getCurrentPosition(function(position) {
			POSITION = new google.maps.LatLng(position.latitude,position.longitude);
			//map.setCenter(initialLocation);
			}, function() {	handleNoGeoLocation(browserSupportFlag); });
// Browser doesn't support Geolocation
		} 
		else 
		{
			browserSupportFlag = false;
			handleNoGeolocation(browserSupportFlag);
		}

		function handleNoGeolocation(errorFlag)
		{
			if (errorFlag == true)
			{
				alert("Geolocation service failed.");
				POSITION = newyork;
			}
			else
			{
				alert("Your browser doesn't support geolocation. We've placed you in Siberia.");
				POSITION = siberia;
			}
			map.setCenter(POSITION);
		}
}



