package Service;

import java.util.List;

import DAO.TransactionDAO;
import Entidad.Transactions;

/**
 * Implementación de la interfaz TransactionService que proporciona la lógica de
 * negocio para manejar transacciones.
 */
public class TransactionServiceImpl implements TransactionService {

	private TransactionDAO transactionDAO;

	/**
	 * Constructor que inicializa la implementación con el TransactionDAO
	 * proporcionado.
	 *
	 * @param transactionDAO el objeto TransactionDAO que maneja la interacción con
	 *                       la base de datos.
	 */
	public TransactionServiceImpl(TransactionDAO transactionDAO) {

		this.transactionDAO = transactionDAO;
	}

	/**
	 * Realiza un depósito en la cuenta del usuario.
	 *
	 * @param transactions el objeto Transactions que contiene los detalles del
	 *                     depósito.
	 * @return true si el depósito se realizó con éxito, false en caso contrario.
	 */
	@Override
	public boolean depositar(Transactions transactions) {
		if (transactions != null && transactions.getDeposito() != 0 && transactions.getDeposito() > 0) {
			return transactionDAO.depositar(transactions);
		} else {
			return false;
		}

	}

	/**
	 * Realiza un retiro de la cuenta del usuario.
	 *
	 * @param transactions el objeto Transactions que contiene los detalles del
	 *                     retiro.
	 * @return true si el retiro se realizó con éxito, false en caso contrario.
	 */
	@Override
	public boolean retirar(Transactions transactions) {
		if (transactions != null && transactions.getRetiro() != 0 && transactions.getRetiro() > 0) {
			return transactionDAO.retirar(transactions);
		} else {
			return false;
		}

	}

	/**
	 * Muestra el saldo actual de la cuenta del usuario.
	 *
	 * @param id el identificador del usuario.
	 * @return el saldo actual de la cuenta del usuario.
	 */
	@Override
	public double mostrarSaldo(int id) {
		return transactionDAO.mostrarSaldo(id);
		
		/**
		 * Muestra la lista de transacciones de la cuenta del usuario.
		 *
		 * @return el listado de la cuenta del usuario.
		 */
	}
	@Override
	public List<Transactions> obtenerTransacciones(){
	return transactionDAO.getListado();
	}
	

}
