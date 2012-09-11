
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


//-------------------------------------------------------------------------------
//scripts de la ventana modal de la actividad
//-------------------------------------------------------------------------------

function showActivity()
{
	
    //Get the screen height and width
    var maskHeight = $(document).height();
    var maskWidth = $(window).width();
 
    //Set height and width to mask to fill up the whole screen
    $('#mask').css({'width':maskWidth,'height':maskHeight});
    
    //transition effect     
    $('#mask').fadeIn(10);    
    $('#mask').fadeTo("slow",0.8);  
    
    //Get the window height and width
    var winH = $(window).height();
    var winW = $(window).width();
          
    //Set the popup window to center
    $("#dialog").css('top',  winH/2-$("#dialog").height()/2);
    $("#dialog").css('left', winW/2-$("#dialog").width()/2);
 
    //transition effect
    $("#dialog").fadeIn(250); 
}

$(document).ready(function() {  
	 
     
    //if close button is clicked
    $('.window .close').click(function (e) {
        //Cancel the link behavior
        e.preventDefault();
        $('#mask, .window').hide();
    });     
     
    //if mask is clicked
    $('#mask').click(function () {
        $(this).hide();
        $('.window').hide();
    });         
     
});