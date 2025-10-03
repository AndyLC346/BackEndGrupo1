package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.RecursoDTO;
import pe.edu.upc.backendgrupo1.entities.Recurso;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRecursoEducativoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recursosducativos")
public class RecursoController {
    @Autowired
    private IRecursoEducativoService rS;

    @GetMapping
    public List<RecursoDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecursoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody RecursoDTO dto) {
        ModelMapper m = new ModelMapper();
        Recurso r = m.map(dto, Recurso.class);
        rS.insert(r);
            return ResponseEntity.status(HttpStatus.CREATED).body("Recurso registrado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Recurso recurso = rS.listId(id);
        if(recurso == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El recurso con el id " + id + " no existe");
        }
        rS.delete(id);
        return ResponseEntity.ok("El recurso con el id " + id+ " ha sido eliminado correctamente");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RecursoDTO dto) {
        ModelMapper m = new ModelMapper();
        Recurso recurso = m.map(dto, Recurso.class);
        if (rS.listId(recurso.getIdRecurso()) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("El recurso con el ID: " + recurso.getIdRecurso() + " no existe");
        }
        rS.update(recurso);
        return ResponseEntity.ok("Recurso actualizada correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarID(@PathVariable("id") Integer id) {
        Recurso recurso = rS.listId(id);
        if(recurso == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe el registro de recurso con el ID: " + id);
        }
        ModelMapper m=new ModelMapper();
        RecursoDTO dto = m.map(recurso, RecursoDTO.class);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/bsuquedatipoynivel")
    public ResponseEntity<?> buscar(@RequestParam String tipo, @RequestParam String nivel) {
        List<Recurso> recursos = rS.buscarRecursoxTipoynivel(tipo,nivel);
        if (recursos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron recursos de ese tipo y/o nivel");
        }
        List<RecursoDTO> listaDTO = recursos.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecursoDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);
    }
    //
}


