package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.RecomendacionDTO;
import pe.edu.upc.backendgrupo1.entities.Recomendacion;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRecomendacionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/recomendaciones")
public class RecomendacionController {

    @Autowired
    private IRecomendacionService reS;

    @GetMapping
    public List<RecomendacionDTO> listar() {
        return reS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, RecomendacionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody RecomendacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Recomendacion re = m.map(dto, Recomendacion.class);
        reS.insert(re);
        return ResponseEntity.status(HttpStatus.CREATED).body("Recomendacion registrada correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Recomendacion recomendacion = reS.listId(id);
        if (recomendacion == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La recomendacion con el id " + id + " no existe");
        }
        reS.delete(id);
        return ResponseEntity.ok("La recomendacion con el id " + id + " ha sido eliminado correctamente");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody RecomendacionDTO dto) {
        ModelMapper m = new ModelMapper();
        Recomendacion recomendacion = m.map(dto, Recomendacion.class);
        if (reS.listId(recomendacion.getIdRecomendacion()) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("La recomendacion con el ID: " + recomendacion.getIdRecomendacion() + " no existe");
        }
        reS.update(recomendacion);
        return ResponseEntity.ok("Recomendacion actualizada correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarID(@PathVariable("id") Integer id) {
        Recomendacion recomendacion = reS.listId(id);
        if (recomendacion == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe el registro de la recomendacion con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        RecomendacionDTO dto = m.map(recomendacion, RecomendacionDTO.class);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<RecomendacionDTO>> buscar(
            @RequestParam(required = false) Integer idUsuario,
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String titulo) {

        List<Recomendacion> recomendaciones = reS.buscarRecomendacionesPorFiltros(idUsuario, categoria, titulo);

        if (recomendaciones.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        ModelMapper m = new ModelMapper();
        List<RecomendacionDTO> listaDTO = recomendaciones.stream()
                .map(r -> m.map(r, RecomendacionDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
}
