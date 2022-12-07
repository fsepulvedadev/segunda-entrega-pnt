escuelita.service.pais = (function () {

    const urlService = "/api/pais/";

    async function buscarPorId(idPais) {
        const urlServiceBuscarPorId = urlService + idPais;
        const data = await fetch(urlServiceBuscarPorId);
        return data.ok ? await data.json() : Promise.reject(response);
    }

    return {
        buscarPorId: buscarPorId
    };

})();