package br.com.fiap.ws.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PACIENTE")
@SequenceGenerator(name="paciente", sequenceName="SEQ_T_PACIENTE" ,allocationSize=1)
public class Paciente {
	
	@Id
	@Column(name="cd_paciente")
	@GeneratedValue(generator="paciente",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_paciente")
	private String nome;
	
	@Column(name="nr_idade")
	private int idade;
	
	
	
	//Construtor Vazio
	public Paciente() {
		super();
	}

	//Construtor Cheio
	public Paciente(String nome, int idade) {
		super();
		setNome(nome);
		setIdade(idade);
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
}
