<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title>Observer :: Show Activities</title></head>
  <body>
    <h1>Activities</h1>
    
     <p><c:forEach var="actividad" items="${activities}">
     ActivityID:<c:out value="${actividad.id}"/>
     ActivityDescription:<c:out value="${actividad.description}"/>
     </c:forEach></p>
  </body>
</html>