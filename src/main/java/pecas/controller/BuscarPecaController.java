package pecas.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pecas.model.Peca;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class BuscarPecaController
 */
@WebServlet("/buscarpecacontroller")
public class BuscarPecaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPecaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   request.setCharacterEncoding("UTF-8");
		   response.setContentType("text/html; charset=UTF-8"); 
		   
		 String nome =  request.getParameter("consultaNome");
		 
		 if (nome == null || nome.trim().isEmpty()) {
	            request.setAttribute("erro", "O nome da peça não pode ser vazio.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp");
	            dispatcher.forward(request, response);
	            return;
	        }
		 ArrayList<Peca> pecas = new Peca().buscarPecaPorNome(nome);
		  	request.setAttribute("pecas", pecas);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp");
	        dispatcher.forward(request, response);
		
	}

}
