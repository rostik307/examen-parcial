package parcial.examen.ejercicio4.repository;


import parcial.examen.ejercicio4.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
