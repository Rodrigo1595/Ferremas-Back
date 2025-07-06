package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.dto.LoginRequest;
import cl.duocuc.asy.ferremas.model.Cliente;
import cl.duocuc.asy.ferremas.services.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Clientes", description = "Gestión de clientes: crear, actualizar, eliminar y consultar clientes por ID, correo o RUT.")
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @Operation(summary = "Obtener cliente por ID", description = "Devuelve los detalles de un cliente específico según su identificador único.")
    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id) {
        return clienteService.findByClienteId(id);
    }

    @Operation(summary = "Obtener cliente por correo", description = "Devuelve los detalles de un cliente específico según su correo electrónico.")
    @GetMapping("/correo/{correo}")
    public Cliente getByCorreo(@PathVariable String correo) {
        return clienteService.findByCorreoCliente(correo);
    }

    @Operation(summary = "Obtener cliente por RUT", description = "Devuelve los detalles de un cliente específico según su RUT.")
    @GetMapping("/rut/{rut}")
    public Cliente getByRut(@PathVariable String rut) {
        return clienteService.findByRutCliente(rut);
    }

    @Operation(summary = "Crear un nuevo cliente", description = "Registra un nuevo cliente en el sistema.")
    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @Operation(summary = "Actualizar cliente", description = "Actualiza los datos de un cliente existente por su ID.")
    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return clienteService.actualizarCliente(cliente);
    }

    @Operation(summary = "Eliminar cliente", description = "Elimina un cliente del sistema por su ID.")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }

    @Operation(summary = "Login de cliente", description = "Permite a un cliente autenticarse usando su correo y contraseña.")
    @PostMapping("/login")
    public Cliente login(@RequestBody LoginRequest loginRequest) {
        return clienteService.login(loginRequest.getCorreo(), loginRequest.getPassword());
    }
}
