package Controllers;

import java.io.IOException;

import DAO.TransactionDAOImpl;

import DAO.TransactionDAO;
import DAO.TransactionDAOImpl;
import Entidad.Transactions;
import Service.TransactionService;
import Service.TransactionServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controlador de servlet para manejar solicitudes relacionadas con
 * transacciones.
 */
@WebServlet("/transaction")
public class TransactionController extends HttpServlet {

	private TransactionService transactionService;

	/**
	 * Inicializa el servlet y configura el TransactionService con una
	 * implementación de TransactionDAO.
	 *
	 * @throws ServletException si ocurre un error de inicialización del servlet.
	 */
	@Override
	public void init() throws ServletException {
		TransactionDAO transactionDAO = new TransactionDAOImpl();
		transactionService = new TransactionServiceImpl(transactionDAO);
	}

	/**
	 * Maneja las solicitudes HTTP POST para realizar depósitos y retiros.
	 *
	 * @param request  el objeto HttpServletRequest que contiene la solicitud del
	 *                 cliente.
	 * @param response el objeto HttpServletResponse que contiene la respuesta del
	 *                 servlet.
	 * @throws ServletException si ocurre un error relacionado con el servlet.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String action = request.getParameter("action");
	        int id = Integer.parseInt(request.getParameter("id"));
	        double amount = 0;

	        try {
	            amount = Double.parseDouble(request.getParameter("amount"));
	        } catch (NumberFormatException e) {
	            amount = 0; 
	        }

	        Transactions transactions = new Transactions();
	        transactions.setId(id);

	        String mensaje = "";
	        String errPage = "result.jsp";
	        try {
	            switch (action) {
	                case "deposit":
	                	 if (amount <= 0) {
		                        errPage = "errorRetiro.jsp"; 
		                        mensaje = "Error: El monto de deposito debe ser mayor que 0.";
		                    } else {
		                        transactions.setDeposito(amount);
		                        transactionService.depositar(transactions);
		                        mensaje = "deposito realizado con éxito.";
		                    }break;
	                case "withdraw":
	                    if (amount <= 0) {
	                        errPage = "errorRetiro.jsp"; 
	                        mensaje = "Error: El monto de retiro debe ser mayor que 0.";
	                    } else {
	                        transactions.setRetiro(amount);
	                        transactionService.retirar(transactions);
	                        mensaje = "Retiro realizado con éxito.";
	                    }
	                    break;
	            }
	        } catch (IllegalArgumentException e) {
	            mensaje = e.getMessage();
	        }
	        double saldo = transactionService.mostrarSaldo(id);
	        request.setAttribute("saldo", saldo);
	        request.setAttribute("mensaje", mensaje);
	        request.getRequestDispatcher(errPage).forward(request, response);
	    }
	}