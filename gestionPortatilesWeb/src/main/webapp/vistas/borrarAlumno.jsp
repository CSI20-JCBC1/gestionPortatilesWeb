<%@ include file="/vistas/cabecera.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
  <title>BorrarAlumnos</title>
  </head>
  <body>
    <h1>Lista de alumnos</h1>
    
    <c:forEach items="${miModelo.listaAlumnosDTO}" var="alumno">
      Id: <c:out value="${alumno.id_alumno}"/> 
      Nombre: <c:out value="${alumno.nombre}"/> 
      Apellidos: <c:out value="${alumno.apellidos}"/>  
      <br><br>
    </c:forEach>
    
    
	
 </body>
</html>