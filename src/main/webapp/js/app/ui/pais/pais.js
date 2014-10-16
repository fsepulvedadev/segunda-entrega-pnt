escuelita.ui.pais = (function () {

    function buscar() {
        escuelita.service.pais.buscar().done(mostrar);
    }

    function mostrar(pais) {
        var $bodyTablaPaises = $("#bodyTablaPaises");
        $bodyTablaPaises.append("<tr><td>" + pais.id + "</td><td>" + pais.nombre + "</td></tr>");
    }

    return {
        buscar: buscar
    };

})();

$(document).ready(function () {
    escuelita.ui.pais.buscar();
});