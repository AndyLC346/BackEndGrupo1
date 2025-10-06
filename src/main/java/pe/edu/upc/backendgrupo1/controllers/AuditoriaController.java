package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.AuditoriaDTO;
import pe.edu.upc.backendgrupo1.entities.Auditoria;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IAuditoriaService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auditorias")
public class AuditoriaController {

    @Autowired
    private IAuditoriaService aS;

    @GetMapping
    @PreAuthorize("hasAuthority('CLIENTE')")
    public List<AuditoriaDTO> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AuditoriaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('DEVELOPER')")
    public ResponseEntity<String> insertar(@RequestBody AuditoriaDTO dto) {
        ModelMapper m = new ModelMapper();
        Auditoria a = m.map(dto, Auditoria.class);
        aS.insert(a);
        return ResponseEntity.status(HttpStatus.CREATED).body("Auditoría registrada correctamente");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DEVELOPER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Auditoria auditoria = aS.listId(id);
        if (auditoria == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La auditoría con ID " + id + " no existe");
        }
        aS.delete(id);
        return ResponseEntity.ok("La auditoría con ID " + id + " fue eliminada correctamente");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('DEVELOPER')")
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

    @GetMapping("/buscarAuditoriaPorusuarioyrangofechas")
    @PreAuthorize("hasAuthority('DEVELOPER')")
    public ResponseEntity<?> buscarAuditoriaPorusuarioyrangofechas(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin, @RequestParam  String tipoAuditoria) {
        List<Auditoria> auditorias = aS.buscarAuditoriasPorFechaYTipo(fechaInicio, fechaFin, tipoAuditoria);
        if (auditorias.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron auditorias en ese rango de fecha y/o tipo: ");
        }
        List<Auditoria> listaDTO = auditorias.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, Auditoria.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
}



