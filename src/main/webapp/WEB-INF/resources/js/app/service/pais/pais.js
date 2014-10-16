escuelita.service.pais = (function () {

    var urlService = "paises.json";

    function buscar() {
        return $.get(urlService);
    }

    return {
        buscar: buscar
    };

})();