package parcial.examen.ejercicio5.service;

import parcial.examen.ejercicio5.model.Sala;
import parcial.examen.ejercicio5.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    public Sala crearSala(Sala sala) {
        return salaRepository.save(sala);
    }

    public List<Sala> obtenerSalas() {
        return salaRepository.findAll();
    }

    public Sala obtenerSalaPorId(Long id) {
        return salaRepository.findById(id).orElse(null);
    }
}
