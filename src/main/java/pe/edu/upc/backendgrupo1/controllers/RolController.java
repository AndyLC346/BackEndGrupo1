package pe.edu.upc.backendgrupo1.controllers;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.*;
import pe.edu.upc.backendgrupo1.entities.Role;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRoleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRoleService rS;


    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('TESTER')")
    public List<RolDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Role r = m.map(dto, Role.class);
        rS.insert(r);
        return ResponseEntity.status(HttpStatus.CREATED).body("Rol registrado correctamente");
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> eliminar(@PathVariable("id") Long id) {
            Role rol = rS.listId(id);
            if(rol == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El rol con el id " + id + " no existe");
            }
            rS.delete(id);
            return ResponseEntity.ok("El rol con el id " + id+ " ha sido eliminado correctamente");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Role rol = m.map(dto, Role.class);
        if (rS.listId(rol.getId()) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("El rol con el ID: " + rol.getRol() + " no existe");
        }
        rS.update(rol);
        return ResponseEntity.ok("Rol actualizado correctamente");
        }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarID(@PathVariable("id") Long id) {
        Role rol = rS.listId(id);
        if(rol == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe el registro del rol con el ID: " + id);
        }
        ModelMapper m=new ModelMapper();
        RolDTO dto = m.map(rol, RolDTO.class);
        return ResponseEntity.ok(dto);
    }
}
