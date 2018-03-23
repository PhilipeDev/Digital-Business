package br.com.fiap.ws.entity;


//A classe medico é uma classe apenas para transferir objetos (TRANSFER OBJECT)
//Portanto não tem @Entity e as outras anotações do JAVA PERSISTENCE.
public class Medico {
	
	private int codigo;
	
	private String nome;
	
	private boolean plantonista;
	
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
