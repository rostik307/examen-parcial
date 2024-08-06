package parcial.examen.ejercicio5.service;


import parcial.examen.ejercicio5.model.Proyeccion;
import parcial.examen.ejercicio5.repository.ProyeccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProyeccionService {
    @Autowired
    private ProyeccionRepository proyeccionRepository;

    public Proyeccion crearProyeccion(Proyeccion proyeccion) {
        return proyeccionRepository.save(proyeccion);
    }

    public List<Proyeccion> obtenerProyecciones() {
        return proyeccionRepository.findAll();
    }

    public Proyeccion obtenerProyeccionPorId(Long id) {
        return proyeccionRepository.findById(id).orElse(null);
    }
}
