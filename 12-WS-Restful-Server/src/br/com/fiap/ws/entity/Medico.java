package br.com.fiap.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MEDICO")
@SequenceGenerator(name="medico", sequenceName="SQ_T_MEDICO", allocationSize=1)
public class Medico {
	
	@Id
	@Column(name="cd_medico")
	@GeneratedValue(generator="medico",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_medico")
	private String nome;
	
	@Column(name="ds_plantao")
	private boolean plantonista;
	
	@Column(name="vl_salario")
	private double salario;
	
	//Construtor Cheio
	public Medico(String nome, boolean plantonista, double salario) {
		super();
		setNome(nome);
		setPlantonista(plantonista);
		setSalario(salario);
	}

	//Construtor Vazio
	public Medico() {
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

	public boolean isPlantonista() {
		return plantonista;
	}

	public void setPlantonista(boolean plantonista) {
		this.plantonista = plantonista;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}
