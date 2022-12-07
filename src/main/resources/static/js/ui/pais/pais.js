escuelita.ui.pais = (function () {

    const bodyTablaPais = document.getElementById("bodyTablaPais");
    const spanIdPaisEncontrado = document.getElementById("idPaisEncontrado");
    const divMensajeNoEncontrado = document.getElementById("mensajeNoEncontrado");

    function inicializar() {
        buscar(1);
        bindearEventosABotones();
    }

    async function buscar(idPais) {
        escuelita.service.pais.buscarPorId(idPais)
            .then(pais => mostrar(pais))
            .catch(error => mostrarMensajeNoEncontrado());
    }

    function mostrar(pais) {
        bodyTablaPais.innerHTML = "<tr><td>" + pais.id + "</td><td>" + pais.nombre + "</td></tr>";
        spanIdPaisEncontrado.textContent = pais.id;
    }

    function bindearEventosABotones() {

        const botonBuscarPaisPorId = document.getElementById("botonBuscarPaisPorId");
        const mensajeNoEncontrado = document.getElementById("mensajeNoEncontrado");
        const spanPaisABuscar = document.getElementById("idPaisABuscar");

        botonBuscarPaisPorId.addEventListener("click", function () {
            mensajeNoEncontrado.classList.add("d-none");
            buscar(spanPaisABuscar.value);
        });
    }

    function mostrarMensajeNoEncontrado() {
        bodyTablaPais.textContent = "";
        spanIdPaisEncontrado.textContent = "";
        divMensajeNoEncontrado.classList.remove("d-none");
    }

    return {
        inicializar: inicializar,
        buscar: buscar
    };

})();

window.addEventListener('DOMContentLoaded', function () {
    escuelita.ui.pais.inicializar();
});
