package cl.duocuc.asy.ferremas.controller;

import cl.duocuc.asy.ferremas.dto.ConsultaClienteCreateDTO;
import cl.duocuc.asy.ferremas.dto.ConsultaClienteResponseDTO;
import cl.duocuc.asy.ferremas.dto.RespuestaVendedorDTO;
import cl.duocuc.asy.ferremas.model.Cliente;
import cl.duocuc.asy.ferremas.model.ConsultaCliente;
import cl.duocuc.asy.ferremas.services.service.ClienteService;
import cl.duocuc.asy.ferremas.services.service.ConsultaClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "ConsultasCliente", description = "Gestión de consultas realizadas por clientes.")
@RestController
@RequestMapping("/api/consultas")
@RequiredArgsConstructor
public class ConsultaClienteController {

    private final ConsultaClienteService consultaClienteService;
    private final ClienteService clienteService;

    @Operation(summary = "Crear una nueva consulta de cliente", description = "Permite a un cliente registrar una nueva consulta o requerimiento. El campo 'resuelto' se inicializa en false.")
    @PostMapping
    public ConsultaClienteResponseDTO create(@RequestBody ConsultaClienteCreateDTO dto) {
        // Assuming you have a ClienteService or a way to fetch Cliente by rut
        Cliente cliente = clienteService.findByRutCliente(dto.getClienteRut());
        ConsultaCliente consulta = ConsultaCliente.builder()
                .cliente(cliente)
                .mensaje(dto.getMensaje())
                .fecha(dto.getFecha())
                .mensajeCliente(dto.getMensajeCliente())
                .resuelto(false)
                .build();
        ConsultaCliente saved = consultaClienteService.crearConsulta(consulta);
        return toResponseDTO(saved);
    }

    @Operation(summary = "Obtener consulta por ID", description = "Devuelve los detalles de una consulta específica según su identificador único.")
    @GetMapping("/{id}")
    public ConsultaClienteResponseDTO getById(@PathVariable Long id) {
        ConsultaCliente consulta = consultaClienteService.findById(id);
        return toResponseDTO(consulta);
    }

    @Operation(summary = "Listar todas las consultas", description = "Obtiene el listado completo de todas las consultas registradas por los clientes.")
    @GetMapping
    public List<ConsultaClienteResponseDTO> getAll() {
        return consultaClienteService.findAll().stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Listar consultas por estado de resolución", description = "Obtiene todas las consultas filtradas por el campo 'resuelto' (true para resueltas, false para pendientes).")
    @GetMapping("/resueltas/{resuelto}")
    public List<ConsultaClienteResponseDTO> getByResuelto(@PathVariable boolean resuelto) {
        return consultaClienteService.findByResuelto(resuelto).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Listar consultas por correo de cliente", description = "Obtiene todas las consultas asociadas al correo del cliente.")
    @GetMapping("/cliente/correo/{correo}")
    public List<ConsultaClienteResponseDTO> getByClienteCorreo(@PathVariable String correo) {
        return consultaClienteService.findByClienteCorreo(correo).stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    private ConsultaClienteResponseDTO toResponseDTO(ConsultaCliente consulta) {
        ConsultaClienteResponseDTO dto = new ConsultaClienteResponseDTO();
        dto.setId(consulta.getId());
        dto.setClienteRut(consulta.getCliente().getRut());
        dto.setMensaje(consulta.getMensaje());
        dto.setFecha(consulta.getFecha());
        dto.setMensajeCliente(consulta.getMensajeCliente());
        dto.setRespuestaVendedor(consulta.getRespuestaVendedor());
        dto.setCorreo(consulta.getEmpleado() != null ? consulta.getEmpleado().getCorreo() : null);
        dto.setResuelto(consulta.isResuelto());
        return dto;
    }

    @Operation(summary = "Responder consulta de cliente", description = "Permite al vendedor responder una consulta y la marca automáticamente como resuelta.")
    @PatchMapping("/{id}/respuesta")
    public ConsultaClienteResponseDTO responderConsulta(
            @PathVariable Long id,
            @RequestBody RespuestaVendedorDTO dto) {
        ConsultaCliente consulta = consultaClienteService.findById(id);
        consulta.setRespuestaVendedor(dto.respuestaVendedor);
        consulta.setResuelto(true);
        ConsultaCliente actualizada = consultaClienteService.actualizarConsulta(consulta);
        return toResponseDTO(actualizada);
    }

}
