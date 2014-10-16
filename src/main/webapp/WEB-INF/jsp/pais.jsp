<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Paises</title>

        <link rel="stylesheet" href="../css/bootstrap.css">
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
                                <th>
                                    ID
                                </th>
                                <th>
                                    Nombre
                                </th>
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
                    <h4>Solo Pais con Id #1</h4>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>
                                    ID
                                </th>
                                <th>
                                    Nombre
                                </th>
                            </tr>
                        </thead>
                        <tbody id="bodyTablaPaises">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Lib JS -->
        <script src="../js/lib/jquery-1.11.1.js"></script>
        <script src="../js/lib/bootstrap.min.js"></script>

        <!-- JS de la aplicacion -->
        <script src="../js/app/escuelita.js"></script>
        <script src="../js/app/ui/ui.js"></script>
        <script src="../js/app/service/service.js"></script>
        <script src="../js/app/ui/pais/pais.js"></script>
        <script src="../js/app/service/pais/pais.js"></script>
    </body>
</html>

