package pe.edu.upc.backendgrupo1.controllers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.UserDTO;
import pe.edu.upc.backendgrupo1.dtos.UserDTO2;
import pe.edu.upc.backendgrupo1.entities.Users;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IUserService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/usuarios")
public class UserController {
    @Autowired
    private IUserService uS;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserDTO2> listar() {
        return uS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UserDTO2.class);
        }).collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users u = m.map(dto, Users.class);
        uS.insert(u);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Long id) {
        Users user = uS.listId(id);
        if(user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con el id " + id + " no existe");
        }
        uS.delete(id);
        return ResponseEntity.ok("El usuario con el id " + id+ " ha sido eliminado correctamente");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody UserDTO dto) {
        ModelMapper m = new ModelMapper();
        Users user = m.map(dto, Users.class);
        if (uS.listId(user.getId()) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("El usuario con el ID: " + user.getId() + " no existe");
        }
        uS.update(user);
        return ResponseEntity.ok("Usuario actualizado correctamente");
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarID(@PathVariable("id") Long id) {
        Users user = uS.listId(id);
        if(user == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe el registro del usuario con el ID: " + id);
        }
        ModelMapper m=new ModelMapper();
        UserDTO2 dto = m.map(user, UserDTO2.class);
        return ResponseEntity.ok(dto);
    }





}
