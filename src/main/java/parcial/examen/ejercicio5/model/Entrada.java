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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public boolean isEsJoven() {
        return esJoven;
    }

    public void setEsJoven(boolean esJoven) {
        this.esJoven = esJoven;
    }

    public boolean isDescuentoGrupo() {
        return descuentoGrupo;
    }

    public void setDescuentoGrupo(boolean descuentoGrupo) {
        this.descuentoGrupo = descuentoGrupo;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    
}
