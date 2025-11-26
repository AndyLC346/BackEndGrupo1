package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.ArchivosDTO;
import pe.edu.upc.backendgrupo1.dtos.BuscarArchivosXFechaDTO;
import pe.edu.upc.backendgrupo1.entities.Archivos;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IArchivosService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
//security
@RestController
@RequestMapping("/archivos")
public class ArchivosController {
    @Autowired
    private IArchivosService aS;

    @GetMapping
    public List<ArchivosDTO> listar() {
        return aS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ArchivosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody ArchivosDTO dto) {
        ModelMapper m = new ModelMapper();
        Archivos a = m.map(dto, Archivos.class);
        aS.insert(a);
        return ResponseEntity.status(HttpStatus.CREATED).body("Archivo registrado correctamente");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Archivos archivo = aS.listId(id);
        if(archivo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El archivo con el id " + id + " no existe");
        }
        aS.delete(id);
        return ResponseEntity.ok("El archivo con el id " + id+ " ha sido eliminado correctamente");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody ArchivosDTO dto) {
        ModelMapper m = new ModelMapper();
        Archivos archivo = m.map(dto, Archivos.class);
        if (aS.listId(archivo.getIdArchivos()) == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("El archivo con el ID: " + archivo.getIdArchivos() + " no existe");
        }
        aS.update(archivo);
        return ResponseEntity.ok("Archivo actualizado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarID(@PathVariable("id") Integer id) {
        Archivos archivo = aS.listId(id);
        if(archivo == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe el registro del archivo con el ID: " + id);
        }
        ModelMapper m=new ModelMapper();
        ArchivosDTO dto = m.map(archivo, ArchivosDTO.class);
        return ResponseEntity.ok(dto);
    }
    @GetMapping("/BuscarArchivosXFecha")
    public ResponseEntity<?> buscarArchivosPorFecha(
            @RequestParam("fechaInicio") LocalDate fechaInicio,
            @RequestParam("fechaFin") LocalDate fechaFin) {

        List<String[]> fila = aS.listarArchivosPorFechas(fechaInicio, fechaFin);
        List<BuscarArchivosXFechaDTO> listaDTO = new ArrayList<>();

        if (fila.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron archivos entre esas fechas");
        }

        for(String[]columna:fila){
            BuscarArchivosXFechaDTO dto = new BuscarArchivosXFechaDTO();
            dto.setNombreArchivo(columna[0]);
            dto.setTipoArchivo(columna[1]);
            dto.setFechaArchivo(LocalDate.parse(columna[2]));
            dto.setUsername(columna[3]);


            listaDTO.add(dto);
        }

        return ResponseEntity.ok(listaDTO);
    }




}
