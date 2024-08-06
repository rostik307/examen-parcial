package parcial.examen.ejercicio4.controller;

import parcial.examen.ejercicio4.model.Director;
import parcial.examen.ejercicio4.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/directors")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping
    public List<Director> getAllDirectors() {
        return directorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        return directorService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Director createDirector(@RequestBody Director director) {
        return directorService.save(director);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable Long id, @RequestBody Director director) {
        return directorService.findById(id)
                .map(existingDirector -> {
                    director.setId(existingDirector.getId());
                    return ResponseEntity.ok(directorService.save(director));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable Long id) {
        directorService.findById(id)
            .map(existingDirector -> {
                directorService.deleteById(id);
                return ResponseEntity.ok().build();
            })
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
