<%@ include file="comunes/cabecero.jsp"%>

<%@ include file="comunes/navegacion.jsp"%>

<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Modificar Empleado</h3>
    </div>
    <form action="${urlModificar}" modelAttribute="empleadoForma" method="post">
        <input type="hidden" name="idEmpleado" value="${empleado.idEmpleado}"/>
        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required value="${empleado.nombreEmpleado}">
        </div>
        <div class="mb-3">
            <label for="departamento" class="form-label">Departamento:</label>
            <input type="text" class="form-control" id="departamento" name="departamento" required value="${empleado.departamento}">
        </div>
        <div class="mb-3">
            <label for="sueldo" class="form-label">Sueldo:</label>
            <input type="number" step="any" class="form-control" id="sueldo" name="sueldo" required value="${empleado.sueldo}">
        </div>
        <button type="submit" class="btn btn-warning btn-sm me-3">Agregar</button>
        <a href="${urlInicio}" class="btn btn-danger btn-sm">Regresar</a>
    </form>
</div>

<%@ include file="comunes/pie-pagina.jsp"%>