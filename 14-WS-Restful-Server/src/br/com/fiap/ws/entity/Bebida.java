package br.com.fiap.ws.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_BEBIDA")
@SequenceGenerator(name="bebida",allocationSize=1,sequenceName="SEQ_T_BEBIDA")
public class Bebida {
	
	@Id
	@GeneratedValue(generator="bebida",strategy=GenerationType.SEQUENCE)
	@Column(name="cd_bebida")
	private int codigo;
	
	@Column(name="nm_bebida")
	private String nome;
	
	@Column(name="ds_alcoolico")
	private boolean alcoolico;
	
	@Column(name="ds_tipo")
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_vencimento")
	private Calendar dataVencimento;

	
	//Construtor cheio
	public Bebida(String nome, boolean alcoolico, Tipo tipo, Calendar dataVencimento) {
		super();
		setNome(nome);
		setAlcoolico(alcoolico);
		setTipo(tipo);
		setDataVencimento(dataVencimento);
	}
	
	
	//Construtor Vazio
	public Bebida() {
		super();
	}



	//Getter's and Setter's
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAlcoolico() {
		return alcoolico;
	}

	public void setAlcoolico(boolean alcoolico) {
		this.alcoolico = alcoolico;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Calendar getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Calendar dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	

}
