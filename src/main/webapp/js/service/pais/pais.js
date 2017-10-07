escuelita.service.pais = (function () {

    var urlService = "/dosideas-java-con-spring-framework/api/pais/";

    function buscarPorId(idPais) {
        var urlServiceBuscarPorId = urlService + idPais;
        return $.get(urlServiceBuscarPorId);
    }

    return {
        buscarPorId: buscarPorId
    };

})();