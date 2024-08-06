package parcial.examen;

import parcial.examen.ejercicio3.model.Telefono;
import parcial.examen.ejercicio3.service.TelefonoService;
import parcial.examen.ejercicio3.repository.TelefonoRepository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class Ejercicio3Test {

    @Autowired
    private TelefonoService telefonoService;

    @Autowired
    private TelefonoRepository telefonoRepository;

    @Disabled("")
    @Test
    public void testEncenderTelefono() {
        Telefono telefono = new Telefono();
        telefono.setId(1L);
        telefono.setEncendido(false);
        Mockito.when(telefonoRepository.findById(1L)).thenReturn(Optional.of(telefono));
        telefono = telefonoService.encenderTelefono(1L);
        assertTrue(telefono.isEncendido());
    }

    @Disabled("")
    @Test
    public void testApagarTelefono() {
        Telefono telefono = new Telefono();
        telefono.setId(1L);
        telefono.setEncendido(true);
        Mockito.when(telefonoRepository.findById(1L)).thenReturn(Optional.of(telefono));
        telefono = telefonoService.apagarTelefono(1L);
        assertFalse(telefono.isEncendido());
    }
    
    @Disabled("")
    @Test
    public void testMarcarNumero() {
        Telefono telefono = new Telefono();
        telefono.setId(1L);
        telefono.setEncendido(true);
        telefono.setEnLlamada(false);
        Mockito.when(telefonoRepository.findById(1L)).thenReturn(Optional.of(telefono));
        telefono = telefonoService.marcarNumero(1L, "123456789");
        assertTrue(telefono.isEnLlamada());
        assertEquals("123456789", telefono.getNumeroMarcado());
    }
    
    @Disabled("")
    @Test
    public void testColgarLlamada() {
        Telefono telefono = new Telefono();
        telefono.setId(1L);
        telefono.setEnLlamada(true);
        Mockito.when(telefonoRepository.findById(1L)).thenReturn(Optional.of(telefono));
        telefono = telefonoService.colgarLlamada(1L);
        assertFalse(telefono.isEnLlamada());
    }
}
