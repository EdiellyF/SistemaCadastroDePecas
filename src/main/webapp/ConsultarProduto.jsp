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
        <form action="processarConsultaProduto.jsp" method="get">
            <div class="mb-3">
                <label for="consultaNome" class="form-label"><strong>Nome da Peça</strong></label>
                <input type="text" id="consultaNome" name="consultaNome" class="form-control" placeholder="Digite o nome da peça para buscar">
            </div>
            <div class="text-center">
                <button type="submit" class="btn btn-success-custom">Buscar Peça</button>
            </div>
        </form>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
