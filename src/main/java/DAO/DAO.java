package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Clase DAO (Data Access Object) que proporciona métodos básicos para
 * conectarse y realizar operaciones en una base de datos.
 */
public  class DAO {
	/**
     * Conexión a la base de datos.
     */
	protected Connection conn;
	/**
     * Resultado de una consulta a la base de datos.
     */
	protected ResultSet rs;
	/**
     * Declaración SQL para ejecutar consultas.
     */
	protected Statement stmt;

	/**
     * Establece una conexión con la base de datos.
     * Si la conexión ya está establecida y abierta, no hace nada.
     * De lo contrario, intenta conectarse a la base de datos .
     */
	protected void conectarDb() {
		try {
			if (conn == null || conn.isClosed()) {

				Class.forName("com.mysql.jdbc.Driver");
				String stringConection = "jdbc:mysql://localhost:3306/wallet";
				String user = "nuevousuario";
				String pass = "1234";
				conn = DriverManager.getConnection(stringConection, user, pass);
				System.out.println("Conectado a la base de datos");
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Error:Driver no encontrado");
		} catch (SQLException ex) {
			System.out.println("Fallo:");
			System.out.println("SQLException:" + ex.getMessage());
			System.out.println("SQLState:" + ex.getSQLState());
			System.out.println("VendorError:" + ex.getErrorCode());
		}
	}
	 /**
     * Ejecuta una consulta SQL y retorna el conjunto de resultados.
     *
     * @param sql la consulta SQL a ejecutar.
     * @return un ResultSet con los resultados de la consulta, o null si la conexión no está establecida o ocurre un error.
     */
	protected ResultSet consultar(String sql) {
		if (conn == null) {
			System.out.println("conexion no establecida");
			return null;
		}
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
	}
	/**
     * Ejecuta una declaración SQL de actualización (INSERT, UPDATE, DELETE).
     *
     * @param sql la declaración SQL a ejecutar.
     * @return el número de registros modificados, o 0 si ocurre un error o la conexión no está establecida.
     */
	protected int ejecutarSql(String sql) {
		if (conn == null) {
			System.out.println("conexion no establecida");

		}
		try {
			stmt = conn.createStatement();
			int regModificados = stmt.executeUpdate(sql);
			return regModificados;

		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return 0;
		}
	}
}