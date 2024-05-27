package Controllers;

import java.io.IOException;

import DAO.UserDAO;
import DAO.UserDAOImpl;
import Service.UserService;
import Service.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Controlador de servlet para manejar las solicitudes de inicio de sesión de
 * usuarios. y procesar las credenciales de inicio de sesión.
 */
@WebServlet("/entrar")
public class UserController extends HttpServlet {

	private UserService userService;
	private UserDAO userDAO;

	/**
	 * Inicializa el servlet y configura el UserService con una implementación de
	 * UserDAO.
	 *
	 * @param config el objeto ServletConfig que contiene la configuración del
	 *               servlet.
	 * @throws ServletException si ocurre un error al inicializar del servlet.
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		userDAO = new UserDAOImpl();
		userService = new UserServiceImpl(userDAO);
	}

	/**
	 * Maneja las solicitudes HTTP GET para mostrar el formulario de inicio de
	 * sesión.
	 *
	 * @param req  el objeto HttpServletRequest que contiene la solicitud del
	 *             cliente.
	 * @param resp el objeto HttpServletResponse que contiene la respuesta del
	 *             servlet.
	 * @throws ServletException si ocurre un error relacionado con el servlet.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/LoginForm.jsp");
		rd.forward(req, resp);
	}

	/**
	 * Maneja las solicitudes HTTP POST para procesar las credenciales de inicio de
	 * sesión.
	 *
	 * @param req  el objeto HttpServletRequest que contiene la solicitud del
	 *             cliente.
	 * @param resp el objeto HttpServletResponse que contiene la respuesta del
	 *             servlet.
	 * @throws ServletException si ocurre un error relacionado con el servlet.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		req.setAttribute("username", name);
		
		if (userService.validacionok(name, pass)) {

			RequestDispatcher rd = req.getRequestDispatcher("/moveform.jsp");
			rd.forward(req, resp);
		} else {
			System.out.println("datos incorrectos");
			RequestDispatcher rs = req.getRequestDispatcher("/loginfail.jsp");
			rs.forward(req, resp);
		}

	}

}
