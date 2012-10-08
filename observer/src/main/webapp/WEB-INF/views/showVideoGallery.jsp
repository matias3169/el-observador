<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Galería de Videos</title>

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

	<ul class="galeria" id="videos">
	    <li>
	       <a rel="prettyPhoto[gallery2]" href="http://youtu.be/WniL0xrH-JQ">
	           <img src="resources/img/thumbnails/flash-logo.png" alt="YouTube" width="75" height="75"/>
	       </a>
	    </li>
	    <li>	    
	        <a rel="prettyPhoto[gallery2]" href="http://youtu.be/WniL0xrH-JQ">
	           <img src="resources/img/thumbnails/flash-logo.png" alt="YouTube" width="75" height="75"/>
	        </a>
	    </li>
	    <li>	    
	       <a rel="prettyPhoto[gallery2]" href="http://youtu.be/QapWaQXcmvo">
	           <img src="resources/img/thumbnails/flash-logo.png" alt="YouTube" width="75" height="75"/>
	       </a>
	    </li>   
	</ul>

<script type="text/javascript">
    $(document).ready(function(){
       $("#videos a[rel^='prettyPhoto']").prettyPhoto({theme: 'dark_square', social_tools:false});
    });
</script>
 
  
</body>
</html>