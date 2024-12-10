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
        
        
        
        String nome; 
        String fornecedor;
        String marca;
        int quantidadeAtual;
        int quantidadeMinima;
        String mensagem = "";
        
       
        
        List<Boolean> validacoes = new ArrayList<>();
        validacoes.add(request.getParameter("marca") != null && !request.getParameter("marca").isEmpty());
        validacoes.add(request.getParameter("fornecedor") != null && !request.getParameter("fornecedor").isEmpty());
        validacoes.add(request.getParameter("nome") != null && !request.getParameter("nome").isEmpty());
        validacoes.add(request.getParameter("quantidadeAtual") != null && !request.getParameter("quantidadeAtual").isEmpty());
        validacoes.add(request.getParameter("quantidadeMinima") != null && !request.getParameter("quantidadeMinima").isEmpty());

        boolean todasValidacoesPassam = validacoes.stream().allMatch(Boolean::booleanValue);
        
        if(todasValidacoesPassam) {
            nome = request.getParameter("nome");
            fornecedor = request.getParameter("fornecedor");
            marca = request.getParameter("marca");
            quantidadeAtual = Integer.parseInt(request.getParameter("quantidadeAtual"));
            quantidadeMinima = Integer.parseInt(request.getParameter("quantidadeMinima"));
            
            Peca peca = new Peca(nome, fornecedor, marca, quantidadeAtual, quantidadeMinima);
            peca.salvar();
            
            mensagem = "Peça cadastrada com sucesso!";
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrarproduto");
            dispatcher.forward(request, response);


        }else {
            List<String> parametros = new ArrayList<>();
            parametros.add("marca");
            parametros.add("fornecedor");
            parametros.add("nome");
            parametros.add("quantidadeAtual");
            parametros.add("quantidadeMinima");

           
            for (int i = 0; i < validacoes.size(); i++) {
                if (!validacoes.get(i)) {
                    mensagem += (parametros.get(i) + " não preenchindo. <br>");
                }
            }
          
            request.setAttribute("mensagem", mensagem);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrarproduto");
            dispatcher.forward(request, response);
        }
        
        
              
        
        
    }

}
