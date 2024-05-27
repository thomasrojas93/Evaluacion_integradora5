package Entidad;

import java.sql.Timestamp;

/**
 * Clase que representa una transacción en el sistema.
 */
public class Transactions {

	private int id;
	private double retiro;
	private double deposito;
	private Timestamp fecha;
	private int usuario_id;
	private double saldo;

	/**
	 * Constructor por defecto.
	 */
	public Transactions() {

	}

	/**
	 * Constructor que inicializa todos los atributos de la clase.
	 *
	 * @param id         el identificador de la transacción.
	 * @param retiro     la cantidad retirada en la transacción.
	 * @param deposito   la cantidad depositada en la transacción.
	 * @param fecha      la fecha y hora de la transacción.
	 * @param usuario_id el identificador del usuario asociado a la transacción.
	 * @param saldo      el saldo resultante después de la transacción.
	 */
	public Transactions(int id, double retiro, double deposito, Timestamp fecha, int usuario_id, double saldo) {

		this.id = id;
		this.retiro = retiro;
		this.deposito = deposito;
		this.fecha = fecha;
		this.usuario_id = usuario_id;
		this.saldo = saldo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getRetiro() {
		return retiro;
	}

	public void setRetiro(double retiro) {
		this.retiro = retiro;
	}

	public double getDeposito() {
		return deposito;
	}

	public void setDeposito(double deposito) {
		this.deposito = deposito;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

}
