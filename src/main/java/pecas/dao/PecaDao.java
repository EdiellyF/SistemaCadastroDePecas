package pecas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pecas.model.Peca;

public class PecaDao {
	public void cadastrarPeca(Peca peca) {
	    String sql = "INSERT INTO pecas (NomePeca, Marca, QuantidadeAtual, QuantidadeMinima, Fornecedor) VALUES (?, ?, ?, ?, ?)";
	    PreparedStatement pStatement = null;
	    Connection conn = null;

	    try {
	        conn = new MySqlConnection().getConnection();
	        if (conn == null) {
	            System.out.println("Erro: Falha ao conectar ao banco de dados.");
	        } else {
	            System.out.println("Conexão com o banco de dados 'pecas' estabelecida com sucesso.");

	
	            pStatement = conn.prepareStatement(sql);

	        
	            pStatement.setString(1, peca.getNomePeca()); 
	            pStatement.setString(2, peca.getMarca()); 
	            pStatement.setInt(3, peca.getQuantidadeAtual()); 
	            pStatement.setInt(4, peca.getQuantidadeMinima());
	            pStatement.setString(5, peca.getFornecedor()); 

	          
	            int resultado = pStatement.executeUpdate();

	       
	            if (resultado > 0) {
	                System.out.println("Peça cadastrada com sucesso!");
	            } else {
	                System.out.println("Erro: Não foi possível cadastrar a peça.");
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar operação no banco de dados: " + e.getMessage());
	    } finally {
	        try {
	            if (pStatement != null) {
	                pStatement.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao fechar recursos: " + e.getMessage());
	        }
	    }
	}
	
	public ArrayList<Peca> buscarPecaPorNome(String nome) {
	    String sql = "SELECT * FROM PECAS WHERE NomePeca LIKE ?";
	    ResultSet rs = null;
	    PreparedStatement pStatement = null;
	    Connection conn = null;
	    Peca peca = null;
	    ArrayList<Peca> pecas = new ArrayList<Peca>();  

	    try {
	        conn = new MySqlConnection().getConnection();
	        if (conn == null) {
	            System.out.println("Erro: Falha ao conectar ao banco de dados.");
	        } else {
	            pStatement = conn.prepareStatement(sql);
	            pStatement.setString(1, "%" + nome + "%");  

	            rs = pStatement.executeQuery();

	            while (rs.next()) {
	                peca = new Peca();
	                peca.setIdPeca(rs.getInt("idPeca"));  
	                peca.setNomePeca(rs.getString("NomePeca"));  
	                peca.setMarca(rs.getString("Marca"));
	                peca.setQuantidadeAtual(rs.getInt("QuantidadeAtual"));
	                peca.setQuantidadeMinima(rs.getInt("QuantidadeMinima"));
	                peca.setFornecedor(rs.getString("Fornecedor"));

	                pecas.add(peca);
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao executar operação no banco de dados: " + e.getMessage());
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (pStatement != null) {
	                pStatement.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	            System.out.println("Erro ao fechar recursos: " + e.getMessage());
	        }
	    }

	    return pecas;  
	}


}
