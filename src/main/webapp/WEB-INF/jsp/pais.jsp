<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Paises</title>

        <link rel="stylesheet" href="vendor/twitter-bootstrap/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>Paises</h1>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-md-6">
                    <h4>Todos</h4>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="pais" items="${paises}">
                                <tr>
                                    <td>${pais.id}</td>
                                    <td>${pais.nombre}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <div id="mensajeNoEncontrado" class="alert alert-warning hide">
                        <strong>No encontrado!</strong> No existe un pais con el ID buscado.
                    </div>
                    <div class="input-group">
                        <input id="idPaisABuscar" type="text" class="form-control" placeholder="#ID pais a buscar">
                        <div class="input-group-btn">
                            <button id="botonBuscarPaisPorId" class="btn btn-info" type="button">Buscar</button>
                        </div>
                    </div>
                    <h4>Solo Pais con Id #<span id="idPaisEncontrado"></span></h4>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                            </tr>
                        </thead>
                        <tbody id="bodyTablaPais"></tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Lib JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/twitter-bootstrap/js/bootstrap.min.js"></script>

        <!-- JS de la aplicacion -->
        <script src="js/escuelita.js"></script>
        <script src="js/ui/ui.js"></script>
        <script src="js/service/service.js"></script>
        <script src="js/ui/pais/pais.js"></script>
        <script src="js/service/pais/pais.js"></script>
    </body>
</html>

