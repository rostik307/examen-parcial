package parcial.examen.ejercicio4.controller;

import parcial.examen.ejercicio4.model.Movie;
import parcial.examen.ejercicio4.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieService.findById(id)
                .map(existingMovie -> {
                    movie.setId(existingMovie.getId());
                    return ResponseEntity.ok(movieService.save(movie));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }   

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
    movieService.findById(id)
        .map(existingMovie -> {
            movieService.deleteById(id);
            return ResponseEntity.ok().build();
        })
        .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
