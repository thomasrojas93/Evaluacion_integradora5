package DAO;

import java.util.List;

import Entidad.Transactions;

/**
 * Interfaz TransactionDAO que define los métodos para realizar operaciones de
 * depósito, retiro y consulta de saldo en una cuenta.
 */
public interface TransactionDAO {
	/**
	 * Realiza un depósito en la cuenta especificada.
	 *
	 * @param transactions el objeto Transactions que contiene la información de la
	 *                     transacción de depósito.
	 * @return true si el depósito se realizó con éxito, false en caso contrario.
	 */
	boolean depositar(Transactions transactions);

	/**
	 * Realiza un retiro de la cuenta especificada.
	 *
	 * @param transactions el objeto Transactions que contiene la información de la
	 *                     transacción de retiro.
	 * @return true si el retiro se realizó con éxito, false en caso contrario.
	 */
	boolean retirar(Transactions transactions);


    /**
     * Muestra el saldo de la cuenta especificada por el ID.
     *
     * @param id el ID de la cuenta cuya saldo se desea consultar.
     * @return el saldo actual de la cuenta.
     */
	double mostrarSaldo(int id);
	
	public List<Transactions> getListado();
}
