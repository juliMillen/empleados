<!--Agregar los url de la aplicacion-->
<c:set var="urlInicio">
    <c:url value="${application.contextPath}/" />
</c:set>

<c:set var="urlAgregar">
    <c:url value="${application.contextPath}/" />
</c:set>


<div class="container">
    <nav class="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${urlInicio}">Sistema de Empleados</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${urlInicio}">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${urlAgregar}">Agregar Empleado</a>
                    </li>
            </div>
        </div>
    </nav>
</div>