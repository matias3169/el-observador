<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Galería de imágenes</title>

<link rel="stylesheet" href="resources/css/prettyPhoto.css" type="text/css"/>
<script src="resources/js/jquery-1.6.1.min.js" type="text/javascript"></script>
<script src="resources/js/jquery.prettyPhoto.js" type="text/javascript"></script>

<style type="text/css">
ul.galeria li {
    display: inline; /* se muestra la galería en horizontal */
}
</style>
</head>
<body>

	<ul class="galeria" id="imagenes">
	    <li>
	       <a rel="prettyPhoto[gallery]" href="resources/img/fullscreen/1.jpg">
	           <img alt="Imagen 1" src="resources/img/thumbnails/t_1.jpg"/>
	        </a>
	    </li>
	    <li>
	        <a rel="prettyPhoto[gallery]" href="resources/img/fullscreen/2.jpg">
	           <img alt="Imagen 2" src="resources/img/thumbnails/t_2.jpg"/>
	        </a>
	    </li>
	    <li>
	       <a rel="prettyPhoto[gallery]" href="resources/img/fullscreen/3.jpg">
	           <img alt="Imagen 3" src="resources/img/thumbnails/t_3.jpg"/>
	       </a>
	    </li>   
	</ul>

<script type="text/javascript">
    $(document).ready(function(){
       $("#imagenes a[rel^='prettyPhoto']").prettyPhoto({theme: 'dark_square',slideshow:5000, autoplay_slideshow:true, social_tools:false});
    });
</script>
 
  
</body>
</html>