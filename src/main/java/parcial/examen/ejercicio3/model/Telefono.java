package parcial.examen.ejercicio3.model;

import jakarta.persistence.*;

@Entity
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private boolean encendido;
    private boolean enLlamada;
    private String numeroMarcado;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public boolean isEncendido() {
        return encendido;
    }
    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
    public boolean isEnLlamada() {
        return enLlamada;
    }
    public void setEnLlamada(boolean enLlamada) {
        this.enLlamada = enLlamada;
    }
    public String getNumeroMarcado() {
        return numeroMarcado;
    }
    public void setNumeroMarcado(String numeroMarcado) {
        this.numeroMarcado = numeroMarcado;
    }

    public void pulsarInterruptor(){
        this.encendido = !this.encendido;
    }

    public void llamar(String numeroMarcado)throws Exception{
        if (this.enLlamada){
            throw new UnsupportedOperationException();
        }else{
            this.enLlamada = true;
            this.numeroMarcado = numeroMarcado;
        }
    }
}
