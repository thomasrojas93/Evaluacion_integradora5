package DAO;

import Entidad.User;
/**
 * Interfaz UserDAO que define los métodos para validación de usuarios.
 */
public interface UserDAO{
	/**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param user el objeto User que contiene la información del usuario a guardar.
     * @return un entero que representa el resultado de la operación (por ejemplo, el ID del usuario guardado o un código de estado).
     */
	int guardar(User user);
	 /**
     * Edita la información de un usuario existente en la base de datos.
     *
     * @param user el objeto User que contiene la información actualizada del usuario.
     * @return un entero que representa el resultado de la operación (por ejemplo, el número de filas afectadas).
     */
	int editar(User user);
	/**
     * Obtiene la información de un usuario.
     *
     * @return un objeto User que contiene la información del usuario.
     */
	User obtener();
	 /**
     * Valida las credenciales de un usuario.
     *
     * @param nombre el nombre del usuario.
     * @param contraseña la contraseña del usuario.
     * @return true si las credenciales son válidas, false en caso contrario.
     */
	boolean validate(String nombre, String contraseña);
}
