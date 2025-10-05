package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.AlertaQuery1DTO;
import pe.edu.upc.backendgrupo1.dtos.CuentaDTO;
import pe.edu.upc.backendgrupo1.entities.Cuenta;
import pe.edu.upc.backendgrupo1.servicesinterfaces.ICuentaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    @Autowired
    private ICuentaService cS;

    @GetMapping
    public List<CuentaDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CuentaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody CuentaDTO dto) {
        ModelMapper m = new ModelMapper();
        Cuenta c = m.map(dto, Cuenta.class);
        cS.insert(c);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cuenta registrada correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Cuenta cuenta = cS.listId(id);
        if (cuenta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La cuenta con ID " + id + " no existe");
        }
        cS.delete(id);
        return ResponseEntity.ok("Cuenta eliminada correctamente");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody CuentaDTO dto) {
        ModelMapper m = new ModelMapper();
        Cuenta cuenta = m.map(dto, Cuenta.class);
        if (cS.listId(cuenta.getIdCuenta()) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("La cuenta con ID " + cuenta.getIdCuenta() + " no existe");
        }
        cS.update(cuenta);
        return ResponseEntity.ok("Cuenta actualizada correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarID(@PathVariable("id") Integer id) {
        Cuenta cuenta = cS.listId(id);
        if (cuenta == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe la cuenta con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        CuentaDTO dto = m.map(cuenta, CuentaDTO.class);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/activas-usuario-fecha")
    public List<CuentaDTO> cuentasActivasPorUsuario(
            @RequestParam int idUser,
            @RequestParam LocalDate fecha) {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CuentaDTO.class);
        }).collect(Collectors.toList());

    }
}
