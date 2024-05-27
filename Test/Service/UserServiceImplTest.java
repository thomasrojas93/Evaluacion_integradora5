package Service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import DAO.UserDAO;
import Entidad.User;

public class UserServiceImplTest {
    private UserServiceImpl userService;
    private UserDAO userDAO;

    @Before
    public void setUp() {
        userDAO = mock(UserDAO.class);
        userService = new UserServiceImpl(userDAO);
    }

    @Test
    public void testAlmacenar() {
        User user = new User(1, "username","email", "password");
        when(userDAO.guardar(user)).thenReturn(1);

        int result = userService.almacenar(user);

        assertEquals(1, result);
        verify(userDAO).guardar(user);
    }

    @Test
    public void testAlmacenar_NullUser() {
        int result = userService.almacenar(null);

        assertEquals(0, result);
        verify(userDAO, never()).guardar(any(User.class));
    }

    @Test
    public void testAlmacenar_BlankNombre() {
        User user = new User(1, "","email", "password");

        int result = userService.almacenar(user);

        assertEquals(0, result);
        verify(userDAO, never()).guardar(any(User.class));
    }

    @Test
    public void testAlmacenar_BlankContrasena() {
        User user = new User(1, "username","email", "");

        int result = userService.almacenar(user);

        assertEquals(0, result);
        verify(userDAO, never()).guardar(any(User.class));
    }

    @Test
    public void testEdicion() {
        User user = new User(1, "username","email", "password");

        int result = userService.edicion(user);

        assertEquals(0, result); // implementación actual siempre devuelve 0
    }

   

    @Test
    public void testValidacionok_ValidCredentials() {
        User user = new User(1, "username","email", "password");
        when(userDAO.obtener()).thenReturn(user);

        boolean result = userService.validacionok("username", "password");

        assertTrue(result);
        verify(userDAO, times(2)).obtener();
    }

    @Test
    public void testValidacionok_InvalidCredentials() {
        User user = new User(1, "username","email", "password");
        when(userDAO.obtener()).thenReturn(user);

        boolean result = userService.validacionok("username", "invalidPassword");

        assertFalse(result);
        verify(userDAO, times(2)).obtener();
    }
}