package cl.duocuc.asy.ferremas.dto;

import cl.duocuc.asy.ferremas.model.RolEmpleado;
import lombok.Data;

@Data
public class EmpleadoCreateDTO {
    private String nombreCompleto;
    private String rut;
    private String correo;
    private String password;
    private RolEmpleado rol;
    private SucursalDTO sucursal;

    @Data
    public static class SucursalDTO {
        private Long id;
    }
}
