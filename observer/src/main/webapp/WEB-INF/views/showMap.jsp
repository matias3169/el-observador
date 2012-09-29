<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE html>
<html>

 <head>
 <meta charset="utf-8"/>
 <title>El Observador</title>
 
 <link href="resources/css/app.css" rel="stylesheet" type="text/css" media="all"/>
 <link href="resources/css/tipTip.css" rel="stylesheet" type="text/css" media="all"/>
  
 <script type="text/javascript" src="https://maps.google.com/maps/api/js?sensor=true"></script>

 <!-- 
 <script type="text/javascript" src="resources/js/jquery-1.8.0.js"></script>
 <script type="text/javascript" src="resources/js/jquery.tipTip.js"></script>
 <script type="text/javascript" src="resources/js/jquery.tipTip.minified.js"></script>
 <script type="text/javascript" src="resources/js/jquery.jrumble.1.3.js"></script>
 <script type="text/javascript" src="resources/js/js_scroll/jquery.nicescroll.js"></script>
 -->
 
 
  	
  
  
  <!-- First, add jQuery (and jQuery UI if using custom easing or animation -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>

<!-- Second, add the Timer and Easing plugins -->
<script type="text/javascript" src="resources/js/js_galeria/jquery.timers-1.2.js"></script>
<script type="text/javascript" src="resources/js/js_galeria/jquery.easing.1.3.js"></script>

<!-- Third, add the GalleryView Javascript and CSS files -->
<script type="text/javascript" src="resources/js/js_galeria/jquery.galleryview-3.0-dev.js"></script>
<link type="text/css" rel="stylesheet" href="resources/css/css_galeria/jquery.galleryview-3.0-dev.css" />
<script type="text/javascript" src="resources/js/js_elasticImput/jquery.elastic.source.js"></script>

<script type="text/javascript" src="resources/js/scripts.js"></script>
<script type="text/javascript" src="resources/js/maps.js"></script>
 
</head>


 <body dvFlowLayout="true" data-davinci-ws="collapse" class="claro" id="myapp">
 <div id="principal" style="height: 649px;">
  <div id="cabecera" style="border: 1px solid black;">

  </div>

 <div id="menu-izquierdo" style="border-style: none; border-color: #f50707; width: 120px; background-image: -webkit-gradient(linear, left top, left bottom, from(#ebe9e9), to(white)); background-image: -o-linear-gradient(#ebe9e9, white); background-image: -ms-linear-gradient(#ebe9e9, white); background-image: -moz-linear-gradient(#ebe9e9, white); background-image: -webkit-linear-gradient(#ebe9e9, white); background-image: linear-gradient(#ebe9e9, white); height: 570px;">
  <ul style="margin: -20px; position: relative; left: 0px; display: block; float: left; margin-top: 100px;list-style-type:none;">
 <li class="menuIzquierdo">
  <div id="item1">
   <img id="favoritos" onclick="ShowMyPlaces();" class="someClass" src="resources/img/sitios_interes_gris.png" alt="Smiley face" width="50" height="50" text="Visulaiza tus lugares favoritos"/>
  </div>
 </li>
    <li class="menuIzquierdo">
  <div id="item2">
   <!--<img src="./img/sitios_interes.png" width="50" height="50" />-->
   </div>
 </li>
    <li class="menuIzquierdo">
  <div id="item3">
   <!--<img src="./img/sitios_interes.png" alt="Smiley face" width="50" height="50"/> --></div>
    </li>
  </ul>
  </div>
  <div id="menu-derecho" style="border-style: none; border-color: #f50707; background-image: -webkit-gradient(linear, left top, left bottom, from(#ebe9e9), to(white)); background-image: -o-linear-gradient(#ebe9e9, white); background-image: -ms-linear-gradient(#ebe9e9, white); background-image: -moz-linear-gradient(#ebe9e9, white); background-image: -webkit-linear-gradient(#ebe9e9, white); background-image: linear-gradient(#ebe9e9, white); height: 570px;">
  <ul id="items-menu-derecho">
 <li class="menuDerecho">
  <img id="actividades" class="someClass" src="resources/img/inbox.png" alt="Smiley face" width="50" height="50" text="Actividades sugeridas"/>
 </li>
  </ul>

  </div>
  
  <div id="map_canvas" style=""></div>
  	<img id="logo" src="resources/img/el-mundo.png" style="width: 150px; height: 150px;"></img>
 </div>
 
<%@include file="activity.jsp" %>
</body></html>
