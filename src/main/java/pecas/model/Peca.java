package pecas.model;

import pecas.dao.PecaDao;

public class Peca {
	private int IdPeca;
	private String nomePeca;
	private String marca;
	private int quantidadeAtual;
	private int quantidadeMinima;
	private String fornecedor;

	
	public Peca() {
	}


	public Peca(int idPeca, String nomePeca, String marca, int quantidadeAtual, int quantidadeMinima,
			String fornecedor) {
		    setNomePeca(nomePeca);
	        setMarca(marca);
	        setQuantidadeAtual(quantidadeAtual);
	        setQuantidadeMinima(quantidadeMinima);
	        setFornecedor(fornecedor);
	}
	
	
	public Peca(String nomePeca, String fornecedor, String marca,  int quantidadeAtual, int quantidadeMinima) {
		super();
		this.nomePeca = nomePeca;
		this.marca = marca;
		this.quantidadeAtual = quantidadeAtual;
		this.quantidadeMinima = quantidadeMinima;
		this.fornecedor = fornecedor;
	}
	
	


	public int getIdPeca() {
		return IdPeca;
	}


	public void setIdPeca(int idPeca) {
		IdPeca = idPeca;
	}


	public String getNomePeca() {
		return nomePeca;
	}
	
	
	public void setNomePeca(String nomePeca) {
        if (nomePeca == null || nomePeca.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da peça não pode ser vazio.");
        }
        this.nomePeca = nomePeca;
    }

	
	
	public String getMarca() {
		return marca;
	}
	
	 public void setMarca(String marca) {
	        if (marca == null || marca.trim().isEmpty()) {
	            throw new IllegalArgumentException("A marca não pode ser vazia.");
	        }
	        this.marca = marca;
	    }
	
	
	
	
	public int getQuantidadeAtual() {
		return quantidadeAtual;
	}
	
	
	public void setQuantidadeAtual(int quantidadeAtual) {
        if (quantidadeAtual < 0) {
            throw new IllegalArgumentException("A quantidade atual não pode ser negativa.");
        }
        this.quantidadeAtual = quantidadeAtual;
    }
	
	
	 public void setQuantidadeMinima(int quantidadeMinima) {
	        if (quantidadeMinima < 0) {
	            throw new IllegalArgumentException("A quantidade mínima não pode ser negativa.");
	        }
	        this.quantidadeMinima = quantidadeMinima;
	    }



	public int getQuantidadeMinima() {
		return quantidadeMinima;
	}
	
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}
	
	public int getIDpeca() {
		return IdPeca;
	}
	
	public void salvar() {
		new PecaDao().cadastrarPeca(this);
	}
	
	
	
	
	
	
}
