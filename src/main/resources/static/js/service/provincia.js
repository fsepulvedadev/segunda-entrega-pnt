export async function buscarPorId(idProvincia) {
    const urlService = "/api/provincia/";
    const urlServiceBuscarPorId = urlService + idProvincia;
    const data = await fetch(urlServiceBuscarPorId);
    return data.ok ? await data.json() : Promise.reject(response);
}