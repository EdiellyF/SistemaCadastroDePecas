# Sistema de Gerenciamento de Peças

Este projeto é um sistema simples de gerenciamento de peças, que permite realizar operações de cadastro de peças no banco de dados, como inserir, listar e consultar informações. O sistema utiliza JDBC para conectar-se ao banco de dados MySQL e manipular os dados.

## Tecnologias Utilizadas

- **Java 8** ou superior
- **JDBC** (Java Database Connectivity) para a conexão com o banco de dados
- **MySQL** como banco de dados
- **Apache Tomcat** para servir a aplicação web (caso esteja usando em ambiente de servidor)

## Pré-Requisitos

Antes de executar o projeto, você precisa garantir que tenha os seguintes requisitos instalados:

1. **Java 8** ou superior
2. **MySQL** instalado e rodando em seu sistema
3. **Apache Tomcat** (se for rodar a aplicação como uma aplicação web)

## Configuração do Banco de Dados

Para configurar o banco de dados, crie um banco de dados MySQL com o nome `pecas` e a tabela `pecas` com a seguinte estrutura:

```sql
CREATE DATABASE pecas;

USE pecas;

CREATE TABLE pecas (
    IdPeca INT AUTO_INCREMENT PRIMARY KEY,
    NomePeca VARCHAR(100) NOT NULL,
    Marca VARCHAR(100) NOT NULL,
    QuantidadeAtual INT NOT NULL,
    QuantidadeMinima INT NOT NULL,
    Fornecedor VARCHAR(100) NOT NULL
);
```


###Funcionalidades
Cadastro de Peças: Permite adicionar peças ao banco de dados com informações como nome, marca, quantidade atual, quantidade mínima e fornecedor.

Listagem de Peças: Exibe todas as peças cadastradas na tabela pecas.

Conexão com MySQL: Utiliza JDBC para realizar a comunicação entre a aplicação Java e o banco de dados MySQL.