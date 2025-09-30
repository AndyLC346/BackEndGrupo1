package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.AuditoriaDTO;
import pe.edu.upc.backendgrupo1.entities.Auditoria;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IAuditoriaService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auditorias")
public class AuditoriaController {

    @Autowired
    private IAuditoriaService aS;

    @GetMapping
    public List<AuditoriaDTO> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AuditoriaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody AuditoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Auditoria a = m.map(dto, Auditoria.class);
        aS.insert(a);
        return ResponseEntity.status(HttpStatus.CREATED).body("Auditoría registrada correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Auditoria auditoria = aS.listId(id);
        if (auditoria == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La auditoría con ID " + id + " no existe");
        }
        aS.delete(id);
        return ResponseEntity.ok("La auditoría con ID " + id + " fue eliminada correctamente");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody AuditoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Auditoria auditoria = m.map(dto, Auditoria.class);
        if (aS.listId(auditoria.getIdAuditoria()) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("La auditoría con el ID: " + auditoria.getIdAuditoria() + " no existe");
        }
        aS.update(auditoria);
        return ResponseEntity.ok("Auditoría actualizada correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarID(@PathVariable("id") Integer id) {
        Auditoria auditoria = aS.listId(id);
        if (auditoria == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe la auditoría con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        AuditoriaDTO dto = m.map(auditoria, AuditoriaDTO.class);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/filtrar-entreFechas-tipoAuditoria")
    public ResponseEntity<?> filtrarAuditorias(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fechaFin,
            @RequestParam(required = false) String tipoAuditoria) {

        List<Object[]> resultados = aS.buscarAuditoriasPorFechaYTipo(fechaInicio, fechaFin, tipoAuditoria);

        List<AuditoriaDTO> lista = resultados.stream().map(x -> {
            AuditoriaDTO dto = new AuditoriaDTO();
            dto.setIdAuditoria(((Number) x[0]).intValue());
            dto.setFechaAuditoria((LocalDateTime) x[1]);
            dto.setTipoAuditoria((String) x[2]);
            dto.setDescripcion((String) x[3]);
            // Usuario
            dto.setUsuario(aS.listId(((Number) x[4]).intValue()).getUsuario());
            return dto;
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body("No se encontraron auditorías para los parámetros indicados.");
        }

        return ResponseEntity.ok(lista);
    }
}
