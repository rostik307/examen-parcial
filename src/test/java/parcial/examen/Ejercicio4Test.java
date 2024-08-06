package parcial.examen;

import parcial.examen.ejercicio4.model.Director;
import parcial.examen.ejercicio4.service.DirectorService;
import parcial.examen.ejercicio4.controller.DirectorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DirectorController.class)
class Ejercicio4Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DirectorService directorService;

    @Test
    void testGetAllDirectors() throws Exception {
        Director director = new Director();
        director.setId(1L);
        director.setName("Steven Spielberg");

        given(directorService.findAll()).willReturn(Collections.singletonList(director));

        mockMvc.perform(get("/directors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Steven Spielberg"));
    }

    @Test
    void testGetDirectorById() throws Exception {
        Director director = new Director();
        director.setId(1L);
        director.setName("Steven Spielberg");

        given(directorService.findById(1L)).willReturn(Optional.of(director));

        mockMvc.perform(get("/directors/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Steven Spielberg"));
    }

    @Test
    void testCreateDirector() throws Exception {
        Director director = new Director();
        director.setId(1L);
        director.setName("Steven Spielberg");

        given(directorService.save(any(Director.class))).willReturn(director);

        mockMvc.perform(post("/directors")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Steven Spielberg\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Steven Spielberg"));
    }

    @Test
    void testUpdateDirector() throws Exception {
        Director director = new Director();
        director.setId(1L);
        director.setName("Steven Spielberg");

        given(directorService.findById(1L)).willReturn(Optional.of(director));
        given(directorService.save(any(Director.class))).willReturn(director);

        mockMvc.perform(put("/directors/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Steven Spielberg\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Steven Spielberg"));
    }

    @Test
    void testDeleteDirector() throws Exception {
        Director director = new Director();
        director.setId(1L);
        director.setName("Steven Spielberg");

        given(directorService.findById(1L)).willReturn(Optional.of(director));
        doNothing().when(directorService).deleteById(1L);

        mockMvc.perform(delete("/directors/1"))
                .andExpect(status().isOk());
    }
}
