escuelita.service.pais = (function () {

    var urlService = "/dosideas-jee001-workshop/pais/1";

    function buscar() {
        return $.get(urlService);
    }

    return {
        buscar: buscar
    };

})();