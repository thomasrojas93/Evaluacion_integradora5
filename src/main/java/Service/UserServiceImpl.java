package Service;

import DAO.UserDAO;
import Entidad.User;

/**
 * Implementación concreta de la interfaz UserService que proporciona la lógica
 * de negocio para gestionar usuarios en el sistema.
 */
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	/**
	 * Constructor que inicializa la implementación con el UserDAO proporcionado.
	 *
	 * @param userDAO el objeto UserDAO que maneja la interacción con la base de
	 *                datos de usuarios.
	 */
	public UserServiceImpl(UserDAO userDAO) {

		this.userDAO = userDAO;
	}

	/**
	 * Almacena un nuevo usuario en el sistema.
	 *
	 * @param user el objeto User que representa al usuario a almacenar.
	 * @return el id del usuario almacenado si se realiza con éxito, 0 en caso
	 *         contrario.
	 */
	@Override
	public int almacenar(User user) {
		if (user != null && !user.getNombre().isBlank() && !user.getContrasena().isBlank()) {
			return userDAO.guardar(user);

		} else {
			return 0;
		}

	}

	/**
	 * Edita los detalles de un usuario existente en el sistema.
	 *
	 * @param user el objeto User que contiene los nuevos detalles del usuario.
	 * @return el número de filas afectadas por la operación de edición.
	 */
	@Override
	public int edicion(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Recupera un usuario por su id.
	 *
	 * @param id el id del usuario a recuperar.
	 * @return el objeto User correspondiente al id proporcionado, o null si no se
	 *         encuentra.
	 */
	@Override
	public User recuperarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Valida las credenciales de inicio de sesión de un usuario.
	 *
	 * @param nombre     el nombre de usuario.
	 * @param contrasena la contraseña del usuario.
	 * @return true si las credenciales son válidas, false en caso contrario.
	 */
	@Override
	public boolean validacionok(String nombre, String contrasena) {
		if (nombre.equals(userDAO.obtener().getNombre()) && contrasena.equals(userDAO.obtener().getContrasena())) {

			return true;
		} else {

			return false;

		}

	}

}
