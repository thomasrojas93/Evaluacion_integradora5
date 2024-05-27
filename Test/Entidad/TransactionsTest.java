package Entidad;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TransactionsTest {
	  private Transactions transaction;

	    @BeforeEach
	    public void setUp() {
	        // Creamos una nueva transacción para cada prueba
	        transaction = new Transactions();
	    }

	    @Test
	    public void testConstructorConParametros() {
	        // Creamos una transacción con parámetros especificados
	        Timestamp fecha = new Timestamp(System.currentTimeMillis());
	        Transactions transaccion = new Transactions(1, 100.0, 0.0, fecha, 123, 100.0);

	        // Verificamos que los atributos de la transacción hayan sido asignados correctamente
	        assertEquals(1, transaccion.getId());
	        assertEquals(100.0, transaccion.getRetiro(), 0.001);
	        assertEquals(0.0, transaccion.getDeposito(), 0.001);
	        assertEquals(fecha, transaccion.getFecha());
	        assertEquals(123, transaccion.getUsuario_id());
	        assertEquals(100.0, transaccion.getSaldo(), 0.001);
	    }

	    @Test
	    public void testSettersAndGetters() {
	        // Establecemos valores usando setters
	        Timestamp fecha = new Timestamp(System.currentTimeMillis());
	        transaction.setId(2);
	        transaction.setRetiro(50.0);
	        transaction.setDeposito(200.0);
	        transaction.setFecha(fecha);
	        transaction.setUsuario_id(456);
	        transaction.setSaldo(250.0);

	        // Verificamos que los valores se asignen y recuperen correctamente
	        assertEquals(2, transaction.getId());
	        assertEquals(50.0, transaction.getRetiro(), 0.001);
	        assertEquals(200.0, transaction.getDeposito(), 0.001);
	        assertEquals(fecha, transaction.getFecha());
	        assertEquals(456, transaction.getUsuario_id());
	        assertEquals(250.0, transaction.getSaldo(), 0.001);
	    }

	    @Test
	    public void testConstructorSinParametros() {
	        // Verificamos que el constructor sin parámetros inicializa correctamente el objeto
	        assertNotNull(transaction);
	        assertEquals(0, transaction.getId());
	        assertEquals(0.0, transaction.getRetiro(), 0.001);
	        assertEquals(0.0, transaction.getDeposito(), 0.001);
	        assertEquals(null, transaction.getFecha());
	        assertEquals(0, transaction.getUsuario_id());
	        assertEquals(0.0, transaction.getSaldo(), 0.001);
	    }
	}

