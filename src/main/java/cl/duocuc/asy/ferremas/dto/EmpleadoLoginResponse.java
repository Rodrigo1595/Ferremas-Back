package cl.duocuc.asy.ferremas.dto;

import cl.duocuc.asy.ferremas.model.RolEmpleado;
import lombok.Data;

@Data
public class EmpleadoLoginResponse {
    private String correo;
    private RolEmpleado rol;
}
