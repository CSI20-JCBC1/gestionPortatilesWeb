<%@ include file="/vistas/cabecera.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
  <title>Formulario</title>
  </head>
  <body>
    <h1>Nuevo Portatil</h1>
    <form:form method="POST" action="guardarAlumno" modelAttribute="alumnoV" path="idPortatil">
             <table>
                <tr>
                    <td><form:label path="nombre">Nombre</form:label></td>
                    <td><form:input path="nombre"/></td>
                </tr>
                <tr>
                    <td><form:label path="apellidos">Apellidos</form:label></td>
                    <td><form:input path="apellidos"/></td>
                </tr>
                <tr>
                    <td><form:label path="num_telefono">Numero de teléfono</form:label></td>
                    <td><form:input path="num_telefono"/></td>
                </tr>
                <tr>
                    <td><form:label type="hidden" path="idPortatil">Id del portatil que quiere </form:label></td>
                    <td><form:input path="idPortatil"/></td>
                </tr>
                
                <tr>
                    <td><input type="submit" value="Guardar"/></td>
                </tr>
            </table>
        </form:form> 
        <p>Mensaje del controlador: <c:out value="${miModelo.mensaje}"/></p>  
 </body>
</html>