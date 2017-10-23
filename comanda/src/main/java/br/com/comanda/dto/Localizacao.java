package br.com.comanda.dto;

import javax.persistence.Entity;

@Entity
public class Localizacao {
	private Long id;
	private String nome;
	private String caminhoImpressao;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCaminhoImpressao() {
		return caminhoImpressao;
	}
	public void setCaminhoImpressao(String caminhoImpressao) {
		this.caminhoImpressao = caminhoImpressao;
	}
	@Override
	public String toString() {
		return "Localizacao [id=" + id + ", nome=" + nome + ", caminhoImpressao=" + caminhoImpressao + "]";
	}
	
	
}
