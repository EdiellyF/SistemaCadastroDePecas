<%@ page import="pecas.model.Peca" %>
<%@ page import="java.util.List"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Consultar Produto - Gestão de Vendas de Carros</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <%@ include file="/partials/navbar.jsp" %>
    <!-- Formulário de Consulta -->
    <main class="main-container">
        <h1 class="text-center mb-4">Consultar Peças</h1>
        <form action="./buscarpecacontroller" method="POST">
            <div class="mb-3">
                <label for="consultaNome" class="form-label"><strong>Nome da Peça</strong></label>
                <input type="text" id="consultaNome" name="consultaNome" class="form-control" placeholder="Digite o nome da peça para buscar">
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success-custom">Buscar Peça</button>
            </div>
        </form>
</main>

       <!-- Resultados da Consulta -->
        <section class="resultados">
            <%
                // Verifica se há peças no request
                List<?> pecas = (List<?>) request.getAttribute("pecas");
                if (pecas != null && !pecas.isEmpty()) {
            %>
            <h2 class="text-center mt-4">Resultados da Busca</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Descrição</th>
                         <th>Ações</th> 
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Object obj : pecas) {
                            Peca peca = (Peca) obj;
                    %>
                    <tr>
                        <td><%= peca.getIdPeca() %></td>
                        <td><%= peca.getNomePeca() %></td>
                        <td><%= peca.getMarca() %></td>
                        <td>
			                    <form action="./editarPecaController" method="POST" style="display: inline;">
			                        <input type="hidden" name="idPeca" value="<%= peca.getIdPeca() %>">
			                        <button type="submit" class="btn btn-warning btn-sm">Editar</button>
			                    </form>
			                    <form action="./apagarPecaController" method="POST" style="display: inline;">
			                        <input type="hidden" name="idPeca" value="<%= peca.getIdPeca() %>">
			                        <button type="submit" class="btn btn-danger btn-sm">Apagar</button>
			                    </form>
               			</td>
                    </tr>
                    <%
                        }
                }  
                
                %>
                
           
                </tbody>
            </table>
       
               <% 
			    String erro = (String) request.getAttribute("erro");
			    if (erro != null) { 
				%>
				    <div class="alert alert-danger alert-dismissible fade show" role="alert">
				        <strong>Erro!</strong> <%= erro %>
				        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				    </div>
				<% 
				    }
				%>
				               
            
        </section>




    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
