package br.com.fiap.jsf.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginBean {
	
	private String usuario;
	private String senha;
	
	public void logar() {
		if(usuario.equals("FIAP") && senha.equals("FIAP2018")) {
			System.out.println("Login realizado com sucesso.");
		}else if(getUsuario()!= "FIAP"){
			System.out.println("Login incorreto.");
		}else if(getSenha()!= "FIAP2018") {
			System.out.println("Senha incorreta.");
		}else {
			System.out.println("Algo de errado não está certo");
		}
	}
	
	//getter's and setter's
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
