package parcial.examen.ejercicio5.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
public class Entrada {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private boolean esJoven;
    private boolean descuentoGrupo;
    private double precioFinal;

    @ManyToOne
    @JoinColumn(name = "proyeccion_id")
    private Proyeccion proyeccion;

    // Getters y Setters
}
