package br.com.comanda.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String codigoBarra;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=true,unique=false)
	private Grupo grupo;
	private String imagemUrl;
	private Double preco;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(nullable=true,unique=false)
	private Localizacao localizacao;
	private int quantidadeEstoque;
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
	public String getCodigoBarra() {
		return codigoBarra;
	}
	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public String getImagemUrl() {
		return imagemUrl;
	}
	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Localizacao getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", codigoBarra=" + codigoBarra + ", grupo=" + grupo
				+ ", imagemUrl=" + imagemUrl + ", preco=" + preco + ", localizacao=" + localizacao
				+ ", quantidadeEstoque=" + quantidadeEstoque + "]";
	}
	
	
	
}
