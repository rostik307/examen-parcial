package parcial.examen.ejercicio5.controller;

import parcial.examen.ejercicio5.model.Proyeccion;
import parcial.examen.ejercicio5.service.ProyeccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyecciones")
public class ProyeccionController {
    @Autowired
    private ProyeccionService proyeccionService;

    @PostMapping
    public Proyeccion crearProyeccion(@RequestBody Proyeccion proyeccion) {
        return proyeccionService.crearProyeccion(proyeccion);
    }

    @GetMapping
    public List<Proyeccion> obtenerProyecciones() {
        return proyeccionService.obtenerProyecciones();
    }
}
