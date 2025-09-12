package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.entities.LogAcceso;
import pe.edu.upc.backendgrupo1.dtos.LogAccesoDTO;
import pe.edu.upc.backendgrupo1.servicesinterfaces.ILogAccesoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logacceso")
public class LogAccesoControllers {

    @Autowired
    private ILogAccesoService laS;

    @GetMapping
    public List<LogAccesoDTO> listar() {
        return laS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, LogAccesoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody LogAccesoDTO dto) {
        ModelMapper m = new ModelMapper();
        LogAcceso la = m.map(dto, LogAcceso.class);
        laS.insert(la);
    }

    @PutMapping
    public void modificar(@RequestBody LogAccesoDTO dto) {
        ModelMapper m = new ModelMapper();
        LogAcceso la = m.map(dto, LogAcceso.class);
        laS.update(la);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Long id) {
        laS.delete(id);
    }

    @GetMapping("/{id}")
    public LogAccesoDTO listarId(@PathVariable("id") Long id) {
        ModelMapper m = new ModelMapper();
        return m.map(laS.searchId(id), LogAccesoDTO.class);
    }
}
