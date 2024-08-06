package parcial.examen.ejercicio3.repository;

import parcial.examen.ejercicio3.model.Telefono;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefonoRepository extends JpaRepository<Telefono, Long> {
}