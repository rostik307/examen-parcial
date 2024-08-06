package parcial.examen.ejercicio5.controller;

import parcial.examen.ejercicio5.model.Entrada;
import parcial.examen.ejercicio5.service.EntradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/entradas")
public class EntradaController {
    @Autowired
    private EntradaService entradaService;

    @PostMapping("/comprar")
    public Entrada comprarEntrada(@RequestBody Entrada entrada) {
        return entradaService.comprarEntrada(entrada);
    }

    @DeleteMapping("/devolver/{id}")
    public void devolverEntrada(@PathVariable UUID id) {
        entradaService.devolverEntrada(id);
    }

    @GetMapping
    public List<Entrada> obtenerEntradas() {
        return entradaService.obtenerEntradas();
    }
}
