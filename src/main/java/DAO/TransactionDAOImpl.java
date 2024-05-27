package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import DAO.DAO;
import Entidad.Transactions;


/**
 * Implementación de la interfaz TransactionDAO para manejar transacciones en
 * una base de datos.
 */
public class TransactionDAOImpl extends DAO implements TransactionDAO {

	public TransactionDAOImpl() {
		conectarDb();
	}

	/**
	 * Realiza un depósito en la cuenta especificada.
	 *
	 * @param transactions el objeto Transactions que contiene la información de la
	 *                     transacción de depósito.
	 * @return true si el depósito se realizó con éxito, false en caso contrario.
	 */
	@Override
	public boolean depositar(Transactions transactions) {

		conectarDb();

		double saldoActual = mostrarSaldo(transactions.getId());

		double nuevoSaldo = saldoActual + transactions.getDeposito();

		String sql = "INSERT INTO transacciones (usuario_id, retiro, deposito, saldo, fecha) VALUES ("
				+ transactions.getId() + ", 0, " + transactions.getDeposito() + ", " + nuevoSaldo + ", NOW())";

		ejecutarSql(sql); // Ejecutar la consulta de inserción
		return false;
	}

	/**
	 * Realiza un retiro de la cuenta especificada.
	 *
	 * @param transactions el objeto Transactions que contiene la información de la
	 *                     transacción de retiro.
	 * @return true si el retiro se realizó con éxito, false en caso contrario.
	 * @throws IllegalArgumentException si los fondos son insuficientes para
	 *                                  realizar el retiro.
	 */
	@Override
	public boolean retirar(Transactions transactions) {
		double saldoActual = mostrarSaldo(transactions.getId());
		if (saldoActual >= transactions.getRetiro()) {

			String sql = "INSERT INTO transacciones (usuario_id, retiro, deposito,saldo, fecha) VALUES("
					+ transactions.getId() + ", " + transactions.getRetiro() + " ,0 , "
					+ (mostrarSaldo(transactions.getId()) - transactions.getRetiro()) + ", NOW())";
			ejecutarSql(sql);

		} else {
			System.out.println("Fondos insuficientes");
			throw new IllegalArgumentException("Fondos insuficientes para realizar el retiro.");
		}
		return false;
	}

	/**
	 * Muestra el saldo de la cuenta especificada por el ID.
	 *
	 * @param id el ID de la cuenta cuya saldo se desea consultar.
	 * @return el saldo actual de la cuenta.
	 */
	@Override
	public double mostrarSaldo(int id) {

		conectarDb();
		double saldo = 0.0;
		String sql = "SELECT saldo FROM transacciones WHERE usuario_id = 1 ORDER BY fecha DESC LIMIT 1";
		ResultSet rs = consultar(sql);

		try {
			if (rs != null && rs.next()) {
				saldo = rs.getDouble("saldo");
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return saldo;
	}
	/**
	 *Crea una lista de transacciones de la cuenta.
	 *
	 
	 */
	@Override
	public List<Transactions> getListado() {
		try {
			List<Transactions> listado= new ArrayList<>();
		
		
			String selectAllsql="select id, usuario_id, retiro, deposito,fecha, saldo  from Transacciones";
			
			ResultSet rsl= this.consultar(selectAllsql);
			
			while(rsl.next()) {
				int id=rsl.getInt("Id");
				int usuario_id=rsl.getInt("usuario_Id");
				double retiro= rsl.getDouble("retiro");
				double deposito= rsl.getDouble("deposito");
				Timestamp fecha=rsl.getTimestamp("fecha");
				double saldo= rsl.getDouble("saldo");
			
				Transactions transactions= new Transactions(id,retiro,deposito,fecha, usuario_id,saldo);
				listado.add(transactions);
				System.out.println("se agrego a la lista");
			}
			
			return listado;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
		
	}
}

	
	
	
