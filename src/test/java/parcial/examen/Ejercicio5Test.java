package parcial.examen;

import parcial.examen.ejercicio5.model.Entrada;
import parcial.examen.ejercicio5.repository.EntradaRepository;
import parcial.examen.ejercicio5.service.EntradaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class Ejercicio5Test {

    @InjectMocks
    private EntradaService entradaService;

    @Mock
    private EntradaRepository entradaRepository;

    public Ejercicio5Test() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testComprarEntrada() {
        Entrada entrada = new Entrada();
        when(entradaRepository.save(any(Entrada.class))).thenReturn(entrada);

        Entrada result = entradaService.comprarEntrada(entrada);
        assertNotNull(result);
        verify(entradaRepository, times(1)).save(entrada);
    }

    @Test
    void testDevolverEntrada() {
        UUID id = UUID.randomUUID();
        doNothing().when(entradaRepository).deleteById(id);

        entradaService.devolverEntrada(id);
        verify(entradaRepository, times(1)).deleteById(id);
    }
}
