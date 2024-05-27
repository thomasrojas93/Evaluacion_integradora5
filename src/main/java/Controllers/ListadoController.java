package Controllers;

import java.io.IOException;
import java.util.List;

import DAO.TransactionDAO;
import DAO.TransactionDAOImpl;
import Entidad.Transactions;
import Service.TransactionService;
import Service.TransactionServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/historic")
public class ListadoController extends HttpServlet {
	private static final long serialVersionUID =1;
	
	private TransactionService transactionService;
	private TransactionDAO transactionDAO;
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		transactionDAO= new TransactionDAOImpl();
		transactionService= new TransactionServiceImpl(transactionDAO);
		
		super.service(arg0, arg1);
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Transactions>listado = transactionService.obtenerTransacciones();
		
		req.setAttribute("listadoTransactions", listado);
		req.getRequestDispatcher("TransactionsTable.jsp").forward(req, resp);
		
	}
}
