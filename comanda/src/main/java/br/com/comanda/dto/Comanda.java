package br.com.comanda.dto;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comanda {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int numeroComanda;
	private Cliente cliente;
	private Calendar horaAbertura;
	private Calendar horaFechamento;
	private Boolean status;
	private TipoComanda tipo;
	private Double desconto;
	private Double valorTotal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNumeroComanda() {
		return numeroComanda;
	}
	public void setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Calendar getHoraAbertura() {
		return horaAbertura;
	}
	public void setHoraAbertura(Calendar horaAbertura) {
		this.horaAbertura = horaAbertura;
	}
	public Calendar getHoraFechamento() {
		return horaFechamento;
	}
	public void setHoraFechamento(Calendar horaFechamento) {
		this.horaFechamento = horaFechamento;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public TipoComanda getTipo() {
		return tipo;
	}
	public void setTipo(TipoComanda tipo) {
		this.tipo = tipo;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@Override
	public String toString() {
		return "Comanda [id=" + id + ", numeroComanda=" + numeroComanda + ", cliente=" + cliente + ", horaAbertura="
				+ horaAbertura + ", horaFechamento=" + horaFechamento + ", status=" + status + ", tipo=" + tipo
				+ ", desconto=" + desconto + ", valorTotal=" + valorTotal + "]";
	}
	
	
	
	

}
