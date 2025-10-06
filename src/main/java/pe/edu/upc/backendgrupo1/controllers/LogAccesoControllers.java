package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.entities.LogAcceso;
import pe.edu.upc.backendgrupo1.dtos.LogAccesoDTO;

import pe.edu.upc.backendgrupo1.servicesinterfaces.ILogAccesoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logacceso")
public class LogAccesoControllers {
    @Autowired
    private ILogAccesoService loS;

    @GetMapping
    @PreAuthorize("hasAuthority('DEVELOPER')")
    public List<LogAccesoDTO> listar() {
        return loS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, LogAccesoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    @PreAuthorize("hasAuthority('DEVELOPER')")
    public ResponseEntity<String> insertar(@RequestBody LogAccesoDTO dto) {
        ModelMapper m = new ModelMapper();
        LogAcceso l = m.map(dto, LogAcceso.class);
        loS.insert(l);
        return ResponseEntity.status(HttpStatus.CREATED).body("Log registrado correctamente");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('DEVELOPER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        LogAcceso logAcceso = loS.listId(id);
        if (logAcceso == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El Log con el id " + id + " no existe");
        }
        loS.delete(id);
        return ResponseEntity.ok("El Log con el id " + id + " ha sido eliminado correctamente");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('DEVELOPER')")
    public ResponseEntity<String> modificar(@RequestBody LogAccesoDTO dto) {
        ModelMapper m = new ModelMapper();
        LogAcceso logAcceso = m.map(dto, LogAcceso.class);
        if (loS.listId(logAcceso.getIdLogAcceso()) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("El Log con el ID: " + logAcceso.getIdLogAcceso() + " no existe");
        }
        loS.update(logAcceso);
        return ResponseEntity.ok("Log actualizado correctamente");
    }


    @GetMapping("/buscarLogsPorusuarioyrangofechas")
    @PreAuthorize("hasAuthority('DEVELOPER')")
    public ResponseEntity<?> buscarLogsPorusuarioyrangofechas(@RequestParam int id, @RequestParam LocalDate fi, @RequestParam LocalDate ff) {
        List<LogAcceso> logAccesos = loS.buscarLogsPorusuarioyrangofechas(id, fi, ff);
        if (logAccesos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron logs con ese usuario y/o rango de fecha: ");
        }
        List<LogAccesoDTO> listaDTO = logAccesos.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, LogAccesoDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
}