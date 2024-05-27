package Entidad;

/**
 * Clase que representa un usuario en el sistema.
 */
public class User {

	private int id;
	private String nombre;
	private String email;
	private String contrasena;

	/**
	 * Constructor por defecto.
	 */
	public User() {

	}

	/**
	 * Constructor que inicializa todos los atributos de la clase.
	 *
	 * @param id         el identificador del usuario.
	 * @param nombre     el nombre del usuario.
	 * @param email      el correo electrónico del usuario.
	 * @param contrasena la contraseña del usuario.
	 */
	public User(int id, String nombre, String email, String contrasena) {

		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.contrasena = contrasena;
	}

	public User(String nombre, String contrasena) {

		this.nombre = nombre;
		this.contrasena = contrasena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
