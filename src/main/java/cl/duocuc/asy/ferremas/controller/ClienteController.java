package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.model.Cliente;
import cl.duocuc.asy.ferremas.services.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Clientes", description = "Gestión de clientes: crear, actualizar, eliminar y consultar clientes por ID, correo o RUT.")
@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id) {
        return clienteService.findByClienteId(id);
    }

    @GetMapping("/correo/{correo}")
    public Cliente getByCorreo(@PathVariable String correo) {
        return clienteService.findByCorreoCliente(correo);
    }

    @GetMapping("/rut/{rut}")
    public Cliente getByRut(@PathVariable String rut) {
        return clienteService.findByRutCliente(rut);
    }

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente);
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return clienteService.actualizarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.eliminarCliente(id);
    }
}
