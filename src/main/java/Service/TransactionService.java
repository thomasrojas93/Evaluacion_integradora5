package Service;

import java.util.List;

import Entidad.Transactions;

/**
 * Interfaz que define los métodos para manejar transacciones en el sistema.
 */
public interface TransactionService {
	/**
	 * Realiza un depósito en la cuenta del usuario.
	 *
	 * @param transactions el objeto Transactions que contiene los detalles del
	 *                     depósito.
	 * @return true si el depósito se realizó con éxito, false en caso contrario.
	 */
	boolean depositar(Transactions transactions);

	/**
	 * Realiza un retiro de la cuenta del usuario.
	 *
	 * @param transactions el objeto Transactions que contiene los detalles del
	 *                     retiro.
	 * @return true si el retiro se realizó con éxito, false en caso contrario.
	 */
	boolean retirar(Transactions transactions);

	/**
	 * Muestra el saldo actual de la cuenta del usuario.
	 *
	 * @param id el identificador del usuario.
	 * @return el saldo actual de la cuenta del usuario.
	 */
	double mostrarSaldo(int id);
	
	public List<Transactions> obtenerTransacciones();
}
