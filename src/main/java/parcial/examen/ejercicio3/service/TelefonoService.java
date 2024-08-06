package parcial.examen.ejercicio3.service;

import parcial.examen.ejercicio3.model.Telefono;
import parcial.examen.ejercicio3.repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TelefonoService {

    @Autowired
    private TelefonoRepository telefonoRepository;

    public Telefono encenderTelefono(Long id) {
        Telefono telefono = telefonoRepository.findById(id).orElseThrow();
        telefono.setEncendido(true);
        return telefonoRepository.save(telefono);
    }

    public Telefono apagarTelefono(Long id) {
        Telefono telefono = telefonoRepository.findById(id).orElseThrow();
        telefono.setEncendido(false);
        return telefonoRepository.save(telefono);
    }

    public Telefono marcarNumero(Long id, String numero) {
        Telefono telefono = telefonoRepository.findById(id).orElseThrow();
        if (telefono.isEncendido() && !telefono.isEnLlamada()) {
            telefono.setNumeroMarcado(numero);
            telefono.setEnLlamada(true);
            return telefonoRepository.save(telefono);
        }
        throw new IllegalStateException("El telefono está apagado o ya está en una llamada.");
    }

    public Telefono colgarLlamada(Long id) {
        Telefono telefono = telefonoRepository.findById(id).orElseThrow();
        telefono.setEnLlamada(false);
        return telefonoRepository.save(telefono);
    }
}
