<%@ include file="/vistas/cabecera.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
  <title>Formulario</title>
  </head>
  <body>
  <h1>Lista de Portatiles</h1>
    
    <c:forEach items="${miModelo.listaPortatilesDTO2}" var="portatil">
      Id (<c:out value="${portatil.id_ordenador}"/>) 
      Modelo (<c:out value="${portatil.modelo}"/>) 
      Marca (<c:out value="${portatil.marca}"/>)  
      <br><br>
    </c:forEach>
    <h1>Nuevo Alumno</h1>
    <form:form method="POST" action="guardarAlumno" modelAttribute="alumnoV" >
             <table>
             <tr>
				IdPortatil
				<select name="idPortatil">

					<c:forEach items="${miModelo.listaPortatilesDTO2}" var="portatil">
						<option><c:out value="${portatil.id_ordenador}" /></option>
					</c:forEach>
				</select>
			</tr>
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
                    <td><input type="submit" value="Guardar"/></td>
                </tr>
            </table>
        </form:form> 
        <p>Mensaje del controlador: <c:out value="${miModelo.mensaje}"/></p>  
 </body>
</html>