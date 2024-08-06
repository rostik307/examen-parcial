package parcial.examen.ejercicio4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 1, max = 100)
    private String title;

    @ManyToOne
    @JoinColumn(name = "director_id", nullable = false)
    private Director director;

    public Movie(){}
    
    public Movie(Long id, @NotBlank @Size(min = 1, max = 100) String title, Director director) {
        this.id = id;
        this.title = title;
        this.director = director;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    
}
