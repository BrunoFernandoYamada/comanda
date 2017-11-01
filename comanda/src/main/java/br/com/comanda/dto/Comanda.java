package br.com.comanda.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Comanda {
	
	private Long id;	
	private int numeroComanda;
	private Cliente cliente;
	private Date horaAbertura;
	private Date horaFechamento;
	private Boolean status;
	private TipoComanda tipo;
	private Double desconto;
	private Double valorTotal;

	@Id
	@GeneratedValue(generator="inc")
	@GenericGenerator(name="inc", strategy="increment")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(unique=false,nullable=false)
	public int getNumeroComanda() {
		return numeroComanda;
	}
	public void setNumeroComanda(int numeroComanda) {
		this.numeroComanda = numeroComanda;
	}
	@OneToOne
	@JoinColumn(unique=false,nullable=true)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Temporal(TemporalType.TIME)
	public Date getHoraAbertura() {
		return horaAbertura;
	}
	public void setHoraAbertura(Date horaAbertura) {
		this.horaAbertura = horaAbertura;
	}
	@Temporal(TemporalType.TIME)
	public Date getHoraFechamento() {
		return horaFechamento;
	}
	public void setHoraFechamento(Date horaFechamento) {
		this.horaFechamento = horaFechamento;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@OneToOne
	@JoinColumn(unique=false,nullable=false)
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
