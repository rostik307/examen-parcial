package parcial.examen.ejercicio5.controller;

import parcial.examen.ejercicio5.model.Sala;
import parcial.examen.ejercicio5.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/salas")
public class SalaController {
    @Autowired
    private SalaService salaService;

    @PostMapping
    public Sala crearSala(@RequestBody Sala sala) {
        return salaService.crearSala(sala);
    }

    @GetMapping
    public List<Sala> obtenerSalas() {
        return salaService.obtenerSalas();
    }
}
