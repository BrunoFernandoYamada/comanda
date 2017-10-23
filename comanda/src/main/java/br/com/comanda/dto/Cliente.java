package br.com.comanda.dto;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Cliente {
	
	private Long id;
	private String nome;
	private String cpfCnpj;
	private String rgIe;
	private char tipoPessoa;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String numeroCasa;
	private String tel;
	private String cel;
	private Date dataNascimento;
	private Date dataCadastro;
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
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getRgIe() {
		return rgIe;
	}
	public void setRgIe(String rgIe) {
		this.rgIe = rgIe;
	}
	public char getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpfCnpj=" + cpfCnpj + ", rgIe=" + rgIe + ", tipoPessoa="
				+ tipoPessoa + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", numeroCasa=" + numeroCasa + ", tel=" + tel + ", cel=" + cel + ", dataNascimento=" + dataNascimento
				+ ", dataCadastro=" + dataCadastro + "]";
	}
	
	
}
