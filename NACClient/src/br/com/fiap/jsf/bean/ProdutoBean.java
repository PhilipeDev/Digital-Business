package br.com.fiap.jsf.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.service.ProdutoService;
import br.com.fiap.ws.to.Produto;

@ManagedBean
public class ProdutoBean {

	private Produto produto;
	
	private ProdutoService service;
	
	private FacesMessage msg;
	
	@PostConstruct
	private void init() {
		produto = new Produto();
		service = new ProdutoService();
	}
	
	public List<Produto> getProdutos(){
		try {
			return service.listar();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String salvar() {
		try {
			service.cadastrar(produto);
			msg = new FacesMessage("Cadastrado!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		//Passa a mensagem para a tela
		FacesContext.getCurrentInstance().addMessage(null, msg);
		//Mantem a mensagem após um redirect
		FacesContext.getCurrentInstance().getExternalContext()
			.getFlash().setKeepMessages(true);
		return "produto?faces-redirect=true";
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}
