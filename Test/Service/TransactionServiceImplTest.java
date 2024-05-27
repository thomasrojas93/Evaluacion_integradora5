package Service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import DAO.TransactionDAO;
import Entidad.Transactions;

class TransactionServiceImplTest {

    private TransactionServiceImpl transactionService;
    private TransactionDAO transactionDAO;

    @BeforeEach
    public void setUp() {
        transactionDAO = mock(TransactionDAO.class);
        transactionService = new TransactionServiceImpl(transactionDAO);
    }

    @Test
    public void testDepositar_SuccessfulDeposit() {
        Transactions transactions = new Transactions(1, 0, 100, null, 1, 0);
        when(transactionDAO.depositar(transactions)).thenReturn(true);

        boolean result = transactionService.depositar(transactions);

        assertTrue(result);
        verify(transactionDAO).depositar(transactions);
    }

    @Test
    public void testDepositar_NullTransactions() {
        boolean result = transactionService.depositar(null);

        assertFalse(result);
        verify(transactionDAO, never()).depositar(any(Transactions.class));
    }

    @Test
    public void testDepositar_ZeroDeposit() {
        Transactions transactions = new Transactions(1, 0, 0, null, 1, 0);

        boolean result = transactionService.depositar(transactions);

        assertFalse(result);
        verify(transactionDAO, never()).depositar(any(Transactions.class));
    }

    @Test
    public void testRetirar_SuccessfulWithdrawal() {
        Transactions transactions = new Transactions(1, 100, 0, null, 1, 0);
        when(transactionDAO.retirar(transactions)).thenReturn(true);

        boolean result = transactionService.retirar(transactions);

        assertTrue(result);
        verify(transactionDAO).retirar(transactions);
    }

    @Test
    public void testRetirar_NullTransactions() {
        boolean result = transactionService.retirar(null);

        assertFalse(result);
        verify(transactionDAO, never()).retirar(any(Transactions.class));
    }

    @Test
    public void testRetirar_ZeroWithdrawal() {
        Transactions transactions = new Transactions(1, 0, 0, null, 1, 0);

        boolean result = transactionService.retirar(transactions);

        assertFalse(result);
        verify(transactionDAO, never()).retirar(any(Transactions.class));
    }

    @Test
    public void testMostrarSaldo() {
        when(transactionDAO.mostrarSaldo(1)).thenReturn(500.0);

        double result = transactionService.mostrarSaldo(1);

        assertEquals(500.0, result, 0);
        verify(transactionDAO).mostrarSaldo(1);
    }
}
