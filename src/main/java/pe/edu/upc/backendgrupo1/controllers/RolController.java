package pe.edu.upc.backendgrupo1.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.backendgrupo1.dtos.RolDTO;
import pe.edu.upc.backendgrupo1.entities.Rol;
import pe.edu.upc.backendgrupo1.servicesinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(name = "/roles")
public class RolController {

}
