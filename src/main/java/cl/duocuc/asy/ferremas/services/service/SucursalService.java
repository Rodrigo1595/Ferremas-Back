package cl.duocuc.asy.ferremas.services.service;

import cl.duocuc.asy.ferremas.model.Sucursal;

public interface SucursalService {
    Sucursal buscarPorId(Long id);
    Sucursal crearSucursal(Sucursal sucursal);
    Sucursal actualizarSucursal(Sucursal sucursal);
    void eliminarSucursal(Long id);
    Iterable<Sucursal> findAll();

}
