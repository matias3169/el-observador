<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title>Observer :: Show Map</title></head>
  <body>
    <h1>Pasting the map</h1>
     <p><c:out value="${date}"/></p>
     <form action="showActivities.htm">
	     CoordenadaX <input type="text" name="coordenadaX"/>
	     CoordenadaY <input type="text" name="coordenadaY"/>
	     Submit<input type="submit"/>
     </form>
  </body>
</html>