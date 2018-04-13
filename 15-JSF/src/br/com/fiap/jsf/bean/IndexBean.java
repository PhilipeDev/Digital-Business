package br.com.fiap.jsf.bean;

//IMPORTANTE!! IMPORT CORRETO
import javax.faces.bean.ManagedBean;

//IMPORTANTE!! IMPORT CORRETO
@ManagedBean
public class IndexBean {
	private String nome;

	public void exibirNome() {
		System.out.println(getNome());
	}
	
	//Getter's and Setter's
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
