package br.com.comanda.dto;

/*
 * Author: Bruno Fernando Yamada
 * As anotações foram colocadas em cima dos metodos por estar usando o SGB Firebird
*/


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class TipoComanda {

	
	private int id;
	
	private String nome;
	/*
	 *   Anotação para gerar chave primária e auto incremente para Firebird
	 */
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name = "inc", strategy = "increment")
	public int getId() {
		return id;
	}


	
	public void setId(int id) {
		this.id = id;
	}


	@Column(length=50,unique=true,nullable=false)
	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	@Override
	public String toString() {
		return "TipoComanda [id=" + id + ", nome=" + nome + "]";
	}
	
	
	
}
