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
import java.util.List;

/**
 * Servlet implementation class CadastrarPecaController
 */

@WebServlet("/cadastrarpeca")
public class CadastrarPecaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarPecaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/html; charset=UTF-8");

	    String nome = request.getParameter("nome");
	    String fornecedor = request.getParameter("fornecedor");
	    String marca = request.getParameter("marca");
	    String quantidadeAtualStr = request.getParameter("quantidadeAtual");
	    String quantidadeMinimaStr = request.getParameter("quantidadeMinima");

	    List<String> erros = validarCampos(nome, fornecedor, marca, quantidadeAtualStr, quantidadeMinimaStr);
	    
	    if (erros.isEmpty()) {
	        int quantidadeAtual = Integer.parseInt(quantidadeAtualStr);
	        int quantidadeMinima = Integer.parseInt(quantidadeMinimaStr);
	        
	        Peca peca = new Peca(nome, fornecedor, marca, quantidadeAtual, quantidadeMinima);
	        peca.salvar();
	        
	        String mensagem = "Peça cadastrada com sucesso!";
	        request.setAttribute("mensagem", mensagem);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrarproduto");
	        dispatcher.forward(request, response);
	    } else {
	        String mensagem = String.join("<br>", erros);
	        request.setAttribute("mensagem", mensagem);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrarproduto");
	        dispatcher.forward(request, response);
	    }
	}
    
    
    private List<String> validarCampos(String nome, String fornecedor, String marca, String quantidadeAtual, String quantidadeMinima) {
        List<String> erros = new ArrayList<>();
        
        if (isNullOrEmpty(nome)) {
            erros.add("Nome não preenchido.");
        }
        if (isNullOrEmpty(fornecedor)) {
            erros.add("Fornecedor não preenchido.");
        }
        if (isNullOrEmpty(marca)) {
            erros.add("Marca não preenchida.");
        }
        if (isNullOrEmpty(quantidadeAtual) || !isNumeric(quantidadeAtual)) {
            erros.add("Quantidade atual inválida.");
        }
        if (isNullOrEmpty(quantidadeMinima) || !isNumeric(quantidadeMinima)) {
            erros.add("Quantidade mínima inválida.");
        }
        
        return erros;
    }
    
    
    private boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
    
    
    
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
     }
    
    }
    
    
    
}
