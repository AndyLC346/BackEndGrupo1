package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.RespuestaSoporteDTO;

import pe.edu.upc.backendgrupo1.entities.RespuestaSoporte;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRespuestaSoporteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/RespuestaSoporte")
public class RespuestaSoporteController {
        @Autowired
        private IRespuestaSoporteService rsS;

        @GetMapping
        public List<RespuestaSoporteDTO> listar(){
            return rsS.list().stream().map(x->{
            ModelMapper m=new ModelMapper();
            return m.map(x,RespuestaSoporteDTO.class);
            }).collect(Collectors.toList());
        }
        @PostMapping
        public ResponseEntity<String>insertar(@RequestBody RespuestaSoporteDTO dto){
            ModelMapper m=new ModelMapper();
            RespuestaSoporte a=m.map(dto, RespuestaSoporte.class);
            rsS.insert(a);
            return ResponseEntity.status(HttpStatus.CREATED).body("Respuesta del Soporte registrado correctamente");
        }
        @DeleteMapping("/{id}")
        public ResponseEntity<String> eliminar(@PathVariable("id")Integer id){
            RespuestaSoporte respuestasoporte=rsS.listId(id);
            if(respuestasoporte==null){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe");
            }rsS.delete(id);
            return ResponseEntity.ok("Se elimino correctamente");
        }
        @PutMapping
        public ResponseEntity<String>modificar(@RequestBody RespuestaSoporteDTO dto) {
            ModelMapper m = new ModelMapper();
            RespuestaSoporte rs = m.map(dto, RespuestaSoporte.class);
            RespuestaSoporte existe = rsS.listId(rs.getIdRespuestaSoporte());
            if (existe == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar");
            }
            rsS.update(rs);
            return ResponseEntity.ok("Se modifico correctamente");
        }
        @GetMapping("/{id}")
        public ResponseEntity<?> listarID(@PathVariable("id") Integer id) {
            RespuestaSoporte respuestaSoporte = rsS.listId(id);
            if (respuestaSoporte == null) {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("No existe el registro del usuario con el ID: " + id);
            }
            ModelMapper m = new ModelMapper();
            RespuestaSoporteDTO dto = m.map(respuestaSoporte, RespuestaSoporteDTO.class);
            return ResponseEntity.ok(dto);
        }
}
