package parcial.examen.ejercicio5.model;


import jakarta.persistence.*;
import java.util.List;

@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int capacidad;

    @OneToMany(mappedBy = "sala")
    private List<Proyeccion> proyecciones;

    // Getters y Setters
}
