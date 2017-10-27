package br.com.comanda.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Localizacao {
	private int id;
	private String nome;
	private String caminhoImpressao;
	
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name="inc", strategy ="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(nullable=false,unique=true,length=50)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(nullable=true,unique=false,length=255)
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
