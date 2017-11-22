package br.com.comanda.dto;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class ItemComanda {
	
	private Long id;
	private Comanda comanda;
	private Produto produto;
	private int quantidade;
	private Double  valorUnit;
	private Double valorToral;
	
	@Id
	@GeneratedValue(generator="inc")
	@GenericGenerator(name = "inc" ,strategy="increment")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@OneToOne(fetch=FetchType.EAGER)
	public Comanda getComanda() {
		return comanda;
	}
	public void setComanda(Comanda comanda) {
		this.comanda = comanda;
	}
	@OneToOne(fetch=FetchType.EAGER)
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Double getValorUnit() {
		return valorUnit;
	}
	public void setValorUnit(Double valorUnit) {
		this.valorUnit = valorUnit;
	}
	public Double getValorToral() {
		return valorToral;
	}
	public void setValorToral(Double valorToral) {
		this.valorToral = valorToral;
	}
	@Override
	public String toString() {
		return "ComandaItemProduto [id=" + id + ", comanda=" + comanda + ", produto=" + produto + ", quantidade="
				+ quantidade + ", valorUnit=" + valorUnit + ", valorToral=" + valorToral + "]";
	}
	
	

}
