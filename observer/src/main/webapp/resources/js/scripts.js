
/*script para los tooltips*/
$(function(){
$(".someClass").tipTip({defaultPosition: "right",delay: "10", attribute:"text"});
});

$(function(){
$("logo").tipTip({defaultPosition: "right",delay: "10", attribute:"text"});
});


//----------------------------------------

//-----------------------------------------

function startRumble(id)
{
miId = "#"+id;
$(miId).jrumble({x: 0,y: 0,rotation: 10,speed: 70});
$(miId).trigger('startRumble');
setTimeout(demoStop, 30);
}

function stopRumble(id)
{
miId = "#"+id;
//$(miId).jrumble();
$(miId).trigger('stopRumble');
}

//-------------------------------------------------------------------------------
// 								geolocalizacion
//-------------------------------------------------------------------------------
var x="a";
function getLocation()
  {
	if (navigator.geolocation)
    {
    navigator.geolocation.getCurrentPosition(showPosition);
    }
	else
	{
	//x.innerHTML="Geolocation is not supported by this browser.";
	alert("No soportado");
	}
  }  
function showPosition(position)
{
  x="Latitude: " + position.coords.latitude + 
  "<br />Longitude: " + position.coords.longitude;	
  
 alert(x);
}

//-------------------------------------------------------------------------------
//					Menu
//-------------------------------------------------------------------------------

/*Scripts de favoritos*/
$(function(){
$("#favoritos").mouseover(function(){ startRumble("item1");},
						  //function(){alert("pepe");}
						  //function(){$('#item').trigger('startRumble');}
						  function(){$(this).attr("src","resources/img/sitios_interes.png");}
						  //function(){ startRumble("item1");}						  
						  );
});

$(function(){
$("#favoritos").mouseout(function(){
  $(this).attr("src","resources/img/sitios_interes_gris.png");
  stopRumble("item1");
});
});

//--------------------------------------------------------------------------------
//			Scripts de google maps
//--------------------------------------------------------------------------------
 function initialize() {
    //temblar();
	
	var latlng = new google.maps.LatLng(-34.9118767, -57.95701059999999);
    var myOptions = {
      zoom: 13,
      center: latlng,
      mapTypeId: google.maps.MapTypeId.TERRAIN
    };
    var map = new google.maps.Map(document.getElementById("map_canvas"),
        myOptions);
  }