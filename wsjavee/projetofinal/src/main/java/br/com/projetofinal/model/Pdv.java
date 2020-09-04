package br.com.projetofinal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table(name = "TB_PDV")//INFORMANDO A TABELA que sera associada
@Entity


public class Pdv {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//chave primaria e auto incremento
	@Column(name="id")
	private int id;
	
	
	@Column(name="numero_ponto")
	private int numero_ponto;
	
	
	@Column(name="nome" , length=100)
	private String nome;
	
	
	@Column(name="endereco" , length=100)
	private String endereço;
	
	
	@Column(name="telefone" , length=20)
	private String telefone;
	
	@OneToMany(mappedBy="pdv", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("pdv")
	private List<Solicitacao> solicitacoes;
	
	
	

	public Pdv() {
		super();
	}

	public Pdv(int id, int numero_ponto, String nome, String endereço, String telefone,
			List<Solicitacao> solicitacoes) {
		super();
		this.id = id;
		this.numero_ponto = numero_ponto;
		this.nome = nome;
		this.endereço = endereço;
		this.telefone = telefone;
		this.solicitacoes = solicitacoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero_ponto() {
		return numero_ponto;
	}

	public void setNumero_ponto(int numero_ponto) {
		this.numero_ponto = numero_ponto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Solicitacao> getSolicitacoes() {
		return solicitacoes;
	}

	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}
	
	
	
	

	
	
	

}
