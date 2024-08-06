package parcial.examen.ejercicio5.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import parcial.examen.ejercicio5.model.Entrada;

public interface EntradaRepository extends JpaRepository<Entrada, UUID> {}
