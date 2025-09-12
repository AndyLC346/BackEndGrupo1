package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.AlertaDTO;
import pe.edu.upc.backendgrupo1.entities.Alerta;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IAlertaService;

import java.util.List;
import java.util.stream.Collectors;
//h
@RestController
@RequestMapping("/alertas")
public class AlertaController {
    @Autowired
    private IAlertaService aS;

    @GetMapping
    public List<AlertaDTO> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, AlertaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alerta a = m.map(dto, Alerta.class);
        aS.insert(a);
        return ResponseEntity.status(HttpStatus.CREATED).body("Alerta registrada correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Alerta alerta = aS.listId(id);
        if(alerta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con el id " + id + " no existe");
        }
        aS.delete(id);
        return ResponseEntity.ok("La alerta con el id " + id+ " ha sido eliminado correctamente");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody AlertaDTO dto) {
        ModelMapper m = new ModelMapper();
        Alerta alerta = m.map(dto, Alerta.class);
        if (aS.listId(alerta.getIdAlerta()) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("La alerta con el ID: " + alerta.getAlertaid() + " no existe");
        }
        aS.update(alerta);
        return ResponseEntity.ok("Alerta actualizada correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarID(@PathVariable("id") Integer id) {
        Alerta alerta = aS.listId(id);
        if(alerta == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe el registro de alerta con el ID: " + id);
        }
        ModelMapper m=new ModelMapper();
        AlertaDTO dto = m.map(alerta, AlertaDTO.class);
        return ResponseEntity.ok(dto);
    }

}
