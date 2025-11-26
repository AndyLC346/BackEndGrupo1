package pe.edu.upc.backendgrupo1.controllers;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.RolDTO;
import pe.edu.upc.backendgrupo1.dtos.UserDTO;
import pe.edu.upc.backendgrupo1.dtos.UserDTO2;
import pe.edu.upc.backendgrupo1.dtos.UserDTO3;
import pe.edu.upc.backendgrupo1.entities.Role;
import pe.edu.upc.backendgrupo1.entities.Users;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRoleService;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRoleService rS;
    @Autowired
    private IUserService uS;

    @GetMapping
    public List<RolDTO> listar() {
        return rS.list().stream().map(role -> {
            RolDTO dto = new RolDTO();
            dto.setId(role.getId());
            dto.setRol(role.getRol());
            dto.setIdusuario(role.getUser() != null ? role.getUser().getId() : null);
            return dto;
        }).collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody RolDTO dto) {
        Users u = uS.listId(dto.getIdusuario());
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe el usuario con id: " + dto.getIdusuario());
        }

        Role r = new Role();
        r.setRol(dto.getRol());
        r.setUser(u);

        rS.insert(r);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Rol registrado correctamente");
    }

    @DeleteMapping("/{id}")
    @Transactional
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
        Role rol = rS.listId(dto.getId());

        if (rol == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe rol con id: " + dto.getRol());
        }

        Users u = uS.listId(dto.getIdusuario());
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe usuario con id: " + dto.getIdusuario());
        }

        rol.setRol(dto.getRol());
        rol.setUser(u);

        rS.update(rol);
        return ResponseEntity.ok("Rol actualizado correctamente");
    }
}
