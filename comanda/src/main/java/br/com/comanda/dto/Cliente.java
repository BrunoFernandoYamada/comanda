package br.com.comanda.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

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
	
	@Id
	@GeneratedValue(generator = "inc")
	@GenericGenerator(name="inc",strategy="increment")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(unique=false,nullable=false,length=255)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(unique=true,nullable=true,length=15)
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	@Column(unique=false,nullable=true,length=15)
	public String getRgIe() {
		return rgIe;
	}
	public void setRgIe(String rgIe) {
		this.rgIe = rgIe;
	}
	@Column(unique=false,nullable=false,length=2)
	public char getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	@Column(unique=false,nullable=true,length=50)
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	@Column(unique=false,nullable=true,length=50)
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	@Column(unique=false,nullable=true,length=50)
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	@Column(unique=false,nullable=true,length=10)
	public String getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	@Column(unique=false,nullable=true,length=12)
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Column(unique=false,nullable=true,length=12)
	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	@Temporal(TemporalType.DATE)
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
