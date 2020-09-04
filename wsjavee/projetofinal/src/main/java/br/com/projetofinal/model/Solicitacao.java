package br.com.projetofinal.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TB_SOLICITACAO")
public class Solicitacao {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//chave primaria e auto incremento
	@Column(name="numSeq")
	private int numSeq;
	
	@Column(name="nomeTecnico" , length=100)	
	private String nomeTecnico;
	
	@Column(name="operadora" , length=50)	
	private String operadora;
	
	@Column(name="telefone" , length=50)	
	private String telefone;
	
	
	@Column(name="doc" , length=20)
	private String doc;
	
	@Column(name="data")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")	
	private Date data;
	
	@Column(name="hora")
	@Temporal(TemporalType.TIME)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm")	
	private Date hora;
	
	
	
	//@OneToMany (lado da chave primaria) e ManyToOne (lado da chave estrangeira)
	@ManyToOne
	@JsonIgnoreProperties("solicitacoes")//ignorar o atributo artista q está em musica
	private Pdv pdv;
	
	@Column(name="status" , length=10)
	private String status;
	
	
	
	public Solicitacao() {
		super();
	}

	public Solicitacao(int numSeq, String nomeTecnico, String operadora, String telefone, String doc, Date data,
			Date hora, Pdv pdv, String status) {
		super();
		this.numSeq = numSeq;
		this.nomeTecnico = nomeTecnico;
		this.operadora = operadora;
		this.telefone = telefone;
		this.doc = doc;
		this.data = data;
		this.hora = hora;
		this.pdv = pdv;
		this.status = status;
	}

	public int getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(int numSeq) {
		this.numSeq = numSeq;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Pdv getPdv() {
		return pdv;
	}

	public void setPdv(Pdv pdv) {
		this.pdv = pdv;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	

	
	
	
	
	
	
	

	
	
	
	
	

}
