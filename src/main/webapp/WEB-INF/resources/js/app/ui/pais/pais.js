escuelita.ui.pais = (function () {

    function buscar() {
        escuelita.service.pais.buscar().done(mostrar);
    }

    function mostrar(paises) {
        var $bodyTablaPaises = $("#bodyTablaPaises");
        $.each(paises, function (index, pais) {
            $bodyTablaPaises.append("<tr><td>" + pais.id +"</td><td>" + pais.nombre + "</td></tr>");
        });
    }

    return {
        buscar: buscar
    };

})();

$(document).ready(function () {
    escuelita.ui.pais.buscar();
});