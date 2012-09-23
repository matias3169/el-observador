
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
    
    //modificamos el tamaño de la ventana
    //alert(((80*100)/maskWidth));
    $("#dialog").css('width', ((80*maskWidth)/100));
    $("#dialog").css('height',((80*$(window).height())/100));
          
    //Set the popup window to center
    $("#dialog").css('top',  winH/2-$("#dialog").height()/2);
    $("#dialog").css('left', winW/2-$("#dialog").width()/2);
 
    //transition effect
    $("#dialog").fadeIn(250); 
    
    //cargamos la aleria
    verGaleria();
    
    //inicializamos los text elasticos
    $(".textComents").elastic();
    
    //modificamos el scrill
    $("body").niceScroll();
    $("#inteactionActivity").niceScroll({cursorborder:"",cursorcolor:"#00F",boxzoom:true});
}

function closeWindows()
{
	$('#mask, .window').hide();
}



function verGaleria(){
	$('#multimedia').galleryView({
	transition_speed: 200, 		//INT - duration of panel/frame transition (in milliseconds)
	transition_interval: 4000, 		//INT - delay between panel/frame transitions (in milliseconds)
	easing: 'swing', 				//STRING - easing method to use for animations (jQuery provides 'swing' or 'linear', more available with jQuery UI or Easing plugin)
	show_panels: true, 				//BOOLEAN - flag to show or hide panel portion of gallery
	show_panel_nav: false, 			//BOOLEAN - flag to show or hide panel navigation buttons
	enable_overlays: true, 			//BOOLEAN - flag to show or hide panel overlays
	
	panel_width: 500, 				//INT - width of gallery panel (in pixels)
	panel_height: 100, 				//INT - height of gallery panel (in pixels)
	panel_animation: 'slide', 		//STRING - animation method for panel transitions (crossfade,fade,slide,none)
	panel_scale: 'crop', 			//STRING - cropping option for panel images (crop = scale image and fit to aspect ratio determined by panel_width and panel_height, fit = scale image and preserve original aspect ratio)
	overlay_position: 'bottom', 	//STRING - position of panel overlay (bottom, top)
	pan_images: true,				//BOOLEAN - flag to allow user to grab/drag oversized images within gallery
	pan_style: 'drag',				//STRING - panning method (drag = user clicks and drags image to pan, track = image automatically pans based on mouse position
	pan_smoothness: 15,				//INT - determines smoothness of tracking pan animation (higher number = smoother)
	start_frame: 1, 				//INT - index of panel/frame to show first when gallery loads
	show_filmstrip: true, 			//BOOLEAN - flag to show or hide filmstrip portion of gallery
	show_filmstrip_nav: true, 		//BOOLEAN - flag indicating whether to display navigation buttons
	enable_slideshow: false,		//BOOLEAN - flag indicating whether to display slideshow play/pause button
	autoplay: false,				//BOOLEAN - flag to start slideshow on gallery load
	show_captions: true, 			//BOOLEAN - flag to show or hide frame captions	
	filmstrip_size: 4, 				//INT - number of frames to show in filmstrip-only gallery
	filmstrip_style: 'scroll', 		//STRING - type of filmstrip to use (scroll = display one line of frames, scroll filmstrip if necessary, showall = display multiple rows of frames if necessary)
	filmstrip_position: 'bottom',  	//STRING - position of filmstrip within gallery (bottom, top, left, right)
	frame_width: 50, 				//INT - width of filmstrip frames (in pixels)
	frame_height: 15, 				//INT - width of filmstrip frames (in pixels)
	frame_opacity: 0.5, 			//FLOAT - transparency of non-active frames (1.0 = opaque, 0.0 = transparent)
	frame_scale: 'crop', 			//STRING - cropping option for filmstrip images (same as above)
	frame_gap: 5, 					//INT - spacing between frames within filmstrip (in pixels)
	show_infobar: true,				//BOOLEAN - flag to show or hide infobar
	infobar_opacity: 10				//FLOAT - transparency for info bar
	});
}


function addComent(){
	//alert("aprete");
	$('#inteactionActivity').append('<div class="userIcon"><img class="userIcon" id="btnCerrar" src="resources/img/user.png" onclick="closeWindows()" width="50" height="50" /></div><div class="bocado-izq"></div><div class="comentario"><textarea class="textComents" rows="" cols=""></textarea><input class="button" type="button" value="Listo!" onclick="addComent()"></div>');
}
