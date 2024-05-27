package Entidad;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class UserTest {
    private User user;

    @BeforeEach
    public void setUp() {
        // Creamos un nuevo usuario para cada prueba
        user = new User();
    }

    @Test
    public void testConstructorConParametros() {
        // Creamos un usuario con parámetros específicos
        User usuario = new User(1, "John Doe", "john@example.com", "password");

        // Verificamos que los atributos del usuario hayan sido asignados bien
        assertEquals(1, usuario.getId());
        assertEquals("John Doe", usuario.getNombre());
        assertEquals("john@example.com", usuario.getEmail());
        assertEquals("password", usuario.getContrasena());
    }

    @Test
    public void testSettersAndGetters() {
        // Establecemos valores usando setters
        user.setId(2);
        user.setNombre("Jane Doe");
        user.setEmail("jane@example.com");
        user.setContrasena("newpassword");

        // Verificamos que los valores se asignen y recuperen correctamente
        assertEquals(2, user.getId());
        assertEquals("Jane Doe", user.getNombre());
        assertEquals("jane@example.com", user.getEmail());
        assertEquals("newpassword", user.getContrasena());
    }

    @Test
    public void testConstructorSinParametros() {
        // Verificamos que el constructor sin parámetros inicializa correctamente el objeto
        assertEquals(0, user.getId());
        assertEquals(null, user.getNombre());
        assertEquals(null, user.getEmail());
        assertEquals(null, user.getContrasena());
    }

    @Test
    public void testConstructorConNombreYContrasena() {
        // Creamos un usuario solo con nombre y contraseña
        User usuario = new User("Alice", "abc123");

        // Verificamos que los valores se asignen correctamente y otros atributos se inicialicen correctamente
        assertEquals(0, usuario.getId());
        assertEquals("Alice", usuario.getNombre());
        assertEquals(null, usuario.getEmail());
        assertEquals("abc123", usuario.getContrasena());
    }
}
