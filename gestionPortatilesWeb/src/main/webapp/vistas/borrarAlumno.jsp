<%@ include file="/vistas/cabecera.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
  <title>BorrarAlumnos</title>
  </head>
  <body>
    <h1>Lista de alumnos</h1>
    
    <c:forEach items="${miModelo.listaAlumnosDTO}" var="alumno">
      Id (<c:out value="${alumno.id_alumno}"/>) 
      Nombre (<c:out value="${alumno.nombre}"/>) 
      Apellidos (<c:out value="${alumno.apellidos}"/>)  
      <br><br>
    </c:forEach>
    
    <form:form method="POST" 
          action="borrarAlum" modelAttribute="alumnoV">
             <table>
                <tr>
                    <td><form:label path="id_alumno">Id de alumno a eliminar</form:label></td>
                    <td><form:input path="id_alumno"/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Borrar"/></td>
                </tr>
            </table>
        </form:form> 
        <p>Mensaje del controlador: <c:out value="${miModelo.mensaje}"/></p>  
    
	
 </body>
</html>