<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Peças - Gestão de Vendas</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
 
</head>
<body>
   
   
     <%@ include file="/partials/navbar.jsp" %>
     
	<% 
	    String mensagem = (String) request.getAttribute("mensagem"); 
	    if (mensagem != null && !mensagem.isEmpty()) { 
	        if(mensagem.equals("Peça cadastrada com sucesso!")){ 
	%>
	    <div class="alert alert-success alert-dismissible fade show" role="alert">
	        <strong>Sucesso!</strong> <%= mensagem %>
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	<% 
	        } else { 
	%>
	    <div class="alert alert-danger alert-dismissible fade show" role="alert">
	        <strong>Erro!</strong> <%= mensagem %>
	        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
	    </div>
	<% 
	        }
	    }
	%>


    <!-- Formulário -->
    <main class="main-container">
        <h1 class="text-center mb-4">Cadastrar Peças</h1>
        <form action="./cadastrarpeca" method="POST">
        
            <div class="mb-3">
                <label for="nome" class="form-label"><strong>Nome da Peça</strong></label>
                <input type="text" id="nome" name="nome" class="form-control" placeholder="Digite o nome da peça" >
            </div>
            <div class="mb-3">
                <label for="fornecedor" class="form-label"><strong>Fornecedor</strong></label>
                <input type="text" id="fornecedor" name="fornecedor" class="form-control" placeholder="Digite o fornecedor" >
            </div>
            <div class="mb-3">
                <label for="marca" class="form-label"><strong>Marca</strong></label>
                <input type="text" id="marca" name="marca" class="form-control" placeholder="Digite a marca" >
            </div>
            <div class="mb-3">
                <label for="quantidadeAtual" class="form-label"><strong>Quantidade Atual</strong></label>
                <input type="number" id="quantidadeAtual" name="quantidadeAtual" class="form-control" placeholder="Digite a quantidade atual" >
            </div>
            <div class="mb-3">
                <label for="quantidadeMinima" class="form-label"><strong>Quantidade Mínima</strong></label>
                <input type="number" id="quantidadeMinima" name="quantidadeMinima" class="form-control" placeholder="Digite a quantidade mínima" >
            </div>
         <div class="text-center">
    <button type="submit" class="btn btn-success-custom">Enviar</button>
</div>
        </form>
    </main>
    
    <h1>
	
    </h1>
    

		

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

