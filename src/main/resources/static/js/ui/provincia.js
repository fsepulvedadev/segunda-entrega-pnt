import { buscarPorId } from "../service/provincia.js";

const bodyTablaPais = document.getElementById("bodyTablaProvincia");
const spanIdProvinciaEncontrado = document.getElementById("idProvinciaEncontrado");
const divMensajeNoEncontrado = document.getElementById("mensajeNoEncontrado");

function inicializar() {
    buscar(1);
    bindearEventosABotones();
}

async function buscar(idProvincia) {
    buscarPorId(idProvincia)
        .then(provincia => mostrar(provincia))
        .catch(error => mostrarMensajeNoEncontrado());
}

function mostrar(provincia) {
    bodyTablaProvincia.innerHTML = "<tr><td>" + provincia.id + "</td><td>" + provincia.nombre + "</td><td>" + provincia.idPais + "</td></tr>";
    spanIdProvinciaEncontrado.textContent = provincia.id;
}

function bindearEventosABotones() {

    const botonBuscarProvinciaPorId = document.getElementById("botonBuscarProvinciaPorId");
    const mensajeNoEncontrado = document.getElementById("mensajeNoEncontrado");
    const spanProvinciaABuscar = document.getElementById("idProvinciaABuscar");

    botonBuscarProvinciaPorId.addEventListener("click", function () {
        mensajeNoEncontrado.classList.add("d-none");
        buscar(spanProvinciaABuscar.value);
    });
}

function mostrarMensajeNoEncontrado() {
    bodyTablaProvincia.textContent = "";
    spanIdProvinciaEncontrado.textContent = "";
    divMensajeNoEncontrado.classList.remove("d-none");
}

window.addEventListener('DOMContentLoaded', function () {
    inicializar();
});
