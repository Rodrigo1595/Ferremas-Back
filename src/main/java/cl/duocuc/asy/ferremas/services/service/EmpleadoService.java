package cl.duocuc.asy.ferremas.services.service;

import cl.duocuc.asy.ferremas.model.Empleado;
import cl.duocuc.asy.ferremas.dto.EmpleadoLoginResponse;

public interface EmpleadoService {
    Empleado obtenerEmpleadoPorId(Long id);

    Empleado crearEmpleado(Empleado usuario);

    Empleado actualizarEmpleado(Empleado usuario);

    void eliminarEmpleado(Long id);

    Empleado obtenerEmpleadoPorEmail(String email);

    EmpleadoLoginResponse login(String correo, String password);
    
}
