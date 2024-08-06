package parcial.examen.ejercicio3.model;

import jakarta.persistence.*;

@Entity
public class Teclado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "telefono_id")
    private Telefono telefono;

    public Teclado(){}

    public Teclado(Long id, Telefono telefono) {
        this.id = id;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }


}
