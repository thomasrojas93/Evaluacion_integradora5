package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entidad.User;
/**
 * Implementación de la interfaz UserDAO para manejar usuarios en una base de datos.
 */
public class UserDAOImpl extends DAO implements UserDAO {

	public UserDAOImpl() {
		this.conectarDb();
	}
	/**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param user el objeto User que contiene la información del usuario a guardar.
     * @return un entero que representa el resultado de la operación (número de filas afectadas).
     */
	@Override
	public int guardar(User user) {
		String sql = "insert into user (nombre,contrasena)";
		sql += " values ('" + user.getNombre() + "','" + user.getContrasena() + "')";
		return this.ejecutarSql(sql);

	}
	 /**
     * Edita la información de un usuario existente en la base de datos.
     * Actualmente no implementado.
     *
     * @param user el objeto User que contiene la información actualizada del usuario.
     * @return un entero que representa el resultado de la operación (actualmente siempre 0).
     */
	@Override
	public int editar(User user) {
		// TODO Auto-generated method stub
		return 0;
	}
	  /**
     * Obtiene la información de un usuario.
     *
     * @return un objeto User que contiene la información del usuario, o null si ocurre un error.
     */
	@Override
	public User obtener() {
		conectarDb();
		try {
			String query = "SELECT * FROM user";
			ResultSet rs = consultar(query);
			User user=new User();
			while (rs.next()) {
				
				String nombre=rs.getString("nombre");
				String contrasena=rs.getString("contrasena");
				 user.setNombre(nombre); 
				 user.setContrasena(contrasena);
			}return user;

		}catch(SQLException e){
			System.out.println("error de obtencion"+e.getMessage());
		return null;
		}
		
	}
	 /**
     * Valida las credenciales de un usuario.
     *
     * @param nombre el nombre del usuario.
     * @param contraseña la contraseña del usuario.
     * @return true si las credenciales son válidas, false en caso contrario.
     */
	@Override
	public boolean validate(String nombre, String contraseña) {
		conectarDb();
		String query = "SELECT * FROM User WHERE nombre = '" + nombre + "' AND contraseña = '" + contraseña + "'";
		ResultSet rs = consultar(query);
		try {
			if (rs.next()) {
				int count = rs.getInt(1);

				return count > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
