package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.TicketReporteDTO;
import pe.edu.upc.backendgrupo1.dtos.TotalTicketsUsuarioDTO;
import pe.edu.upc.backendgrupo1.entities.TicketReporte;
import pe.edu.upc.backendgrupo1.servicesinterfaces.ITicketReporteService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticketreportes")
public class TicketReporteController {
    @Autowired
    private ITicketReporteService trS;
    @GetMapping
    public List<TicketReporteDTO> listar(){
        ModelMapper m = new ModelMapper();
        return trS.list().stream()
                .map(x -> m.map(x, TicketReporteDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping
    public void insertar(@RequestBody TicketReporteDTO dto){
        ModelMapper m=new ModelMapper();
        TicketReporte t=m.map(dto,TicketReporte.class);
        trS.insert(t);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminar(@PathVariable("id")Integer id){
        TicketReporte ticketreporte=trS.listId(id);
        if(ticketreporte==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe");
        }trS.delete(id);
        return ResponseEntity.ok("Se elimino correctamente");
    }
    @PutMapping
    public ResponseEntity<String>modificar(@RequestBody TicketReporteDTO dto){
        ModelMapper m=new ModelMapper();
        TicketReporte t=m.map(dto,TicketReporte.class);
        TicketReporte existe=trS.listId(t.getIdSoporte());
        if(existe==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se puede modificar");
        }
        trS.update(t);
        return ResponseEntity.ok("Se modifico correctamente");
    }
    @GetMapping("/ContarTicktesPorUsuario")
    public ResponseEntity<?> contarTicketsPorUsuario() {
        List<TotalTicketsUsuarioDTO>dtos=new ArrayList<>();
        List<String[]>resultados=trS.TotalTicketsPorUsuario();
        for(String[] x:resultados){
            TotalTicketsUsuarioDTO dto=new TotalTicketsUsuarioDTO();
            dto.setIdUusuario(Integer.parseInt(x[0].toString()));
            dto.setUsername(x[1]);
            dto.setTotal_Tickets(Integer.parseInt(x[2].toString()));
            dtos.add(dto);
        }
        return ResponseEntity.ok(dtos);
    }
}
