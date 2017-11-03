package br.com.comanda.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Config {
	
	private int id;
	private int quantComanda;
	private int quantDelivey;
	private int quantFastSell;
	
	@Id
	@GeneratedValue(generator="inc")
	@GenericGenerator(name="inc", strategy ="increment")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantComanda() {
		return quantComanda;
	}
	public void setQuantComanda(int quantComanda) {
		this.quantComanda = quantComanda;
	}
	public int getQuantDelivey() {
		return quantDelivey;
	}
	public void setQuantDelivey(int quantDelivey) {
		this.quantDelivey = quantDelivey;
	}
	public int getQuantFastSell() {
		return quantFastSell;
	}
	public void setQuantFastSell(int quantFastSell) {
		this.quantFastSell = quantFastSell;
	}
	@Override
	public String toString() {
		return "Config [id=" + id + ", quantComanda=" + quantComanda + ", quantDelivey=" + quantDelivey
				+ ", quantFastSell=" + quantFastSell + "]";
	}
	
	

}
