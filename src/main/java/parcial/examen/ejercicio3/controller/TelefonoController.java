package parcial.examen.ejercicio3.controller;

import parcial.examen.ejercicio3.model.Telefono;
import parcial.examen.ejercicio3.service.TelefonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/telefono")
public class TelefonoController {

    @Autowired
    private TelefonoService telefonoService;

    @PostMapping("/encender/{id}")
    public Telefono encenderTelefono(@PathVariable Long id) {
        return telefonoService.encenderTelefono(id);
    }

    @PostMapping("/apagar/{id}")
    public Telefono apagarTelefono(@PathVariable Long id) {
        return telefonoService.apagarTelefono(id);
    }

    @PostMapping("/marcar/{id}")
    public Telefono marcarNumero(@PathVariable Long id, @RequestParam String numero) {
        return telefonoService.marcarNumero(id, numero);
    }

    @PostMapping("/colgar/{id}")
    public Telefono colgarLlamada(@PathVariable Long id) {
        return telefonoService.colgarLlamada(id);
    }
}
