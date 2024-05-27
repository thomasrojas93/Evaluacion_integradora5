package DAO;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Entidad.Transactions;

public class TransactionDAOImplTest {
    private TransactionDAOImpl transactionDAO;
    private Transactions transactions;

    @BeforeEach
    public void setUp() {
        transactionDAO = spy(new TransactionDAOImpl());
        transactions = new Transactions(1, 100, 50,  null, 123, 1000);
    }

    @Test
    public void testDepositar() throws SQLException {
        doNothing().when(transactionDAO).conectarDb();
        when(transactionDAO.mostrarSaldo(1)).thenReturn(1000.0);
        when(transactionDAO.ejecutarSql(anyString())).thenReturn(1);

        boolean resultado = transactionDAO.depositar(transactions);

        assertTrue(resultado);
        verify(transactionDAO).conectarDb();
        verify(transactionDAO).mostrarSaldo(1);
        verify(transactionDAO).ejecutarSql(anyString());
    }

    @Test
    public void testRetirar_saldoSuficiente() throws SQLException {
        doNothing().when(transactionDAO).conectarDb();
        when(transactionDAO.mostrarSaldo(1)).thenReturn(1000.0);
        when(transactionDAO.ejecutarSql(anyString())).thenReturn(1);

        boolean resultado = transactionDAO.retirar(transactions);

        assertTrue(resultado);
        verify(transactionDAO).conectarDb();
        verify(transactionDAO).mostrarSaldo(1);
        verify(transactionDAO).ejecutarSql(anyString());
    }

    @Test
    public void testMostrarSaldo() throws SQLException {
        doNothing().when(transactionDAO).conectarDb();
        ResultSet resultSet = mock(ResultSet.class);
        when(transactionDAO.consultar(anyString())).thenReturn(resultSet);
        when(resultSet.getDouble("saldo")).thenReturn(1000.0);

        double saldo = transactionDAO.mostrarSaldo(1);

        assertEquals(1000.0, saldo, 0.001);
        verify(transactionDAO).conectarDb();
        verify(transactionDAO).consultar(anyString());
    }
}
