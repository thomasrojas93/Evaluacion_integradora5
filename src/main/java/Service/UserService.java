package Service;

import Entidad.User;

/**
 * Implementación concreta de la interfaz UserService que proporciona la lógica
 * de negocio para gestionar usuarios en el sistema.
 */
public interface UserService {
	/**
	 * Almacena un nuevo usuario en el sistema.
	 *
	 * @param user el objeto User que representa al usuario a almacenar.
	 * @return el id del usuario almacenado.
	 */
	int almacenar(User user);

	/**
	 * Edita los detalles de un usuario existente en el sistema.
	 *
	 * @param user el objeto User que contiene los nuevos detalles del usuario.
	 * @return el número de filas afectadas por la operación de edición.
	 */
	int edicion(User user);

	/**
	 * Recupera un usuario por su id.
	 *
	 * @param id el id del usuario a recuperar.
	 * @return el objeto User correspondiente al id proporcionado, o null si no se
	 *         encuentra.
	 */
	User recuperarPorId(int id);

	/**
	 * Valida las credenciales de inicio de sesión de un usuario.
	 *
	 * @param nombre     el nombre de usuario.
	 * @param contraseña la contraseña del usuario.
	 * @return true si las credenciales son válidas, false en caso contrario.
	 */
	boolean validacionok(String nombre, String contraseña);
}
