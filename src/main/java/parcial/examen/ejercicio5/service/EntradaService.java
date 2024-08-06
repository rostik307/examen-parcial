package parcial.examen.ejercicio5.service;

import parcial.examen.ejercicio5.model.Entrada;
import parcial.examen.ejercicio5.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class EntradaService {
    @Autowired
    private EntradaRepository entradaRepository;

    public Entrada comprarEntrada(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    public void devolverEntrada(UUID id) {
        entradaRepository.deleteById(id);
    }

    public List<Entrada> obtenerEntradas() {
        return entradaRepository.findAll();
    }
}
