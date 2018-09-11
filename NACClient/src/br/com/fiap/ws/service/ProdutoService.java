package br.com.fiap.ws.service;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.to.Produto;

public class ProdutoService {

	private static final String URL = "http://localhost:8080/NACServer/rest/produto";
	
	private WebResource resource;
	
	public ProdutoService() {
		resource = Client.create().resource(URL);
	}
	
	public void cadastrar(Produto produto) throws Exception {
		ClientResponse resp = resource
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, produto);
		
		if (resp.getStatus() != 201) {
			throw new Exception("Erro");
		}
	}
	
	public void atualizar(Produto produto) throws Exception {
		ClientResponse resp = resource
				.path(String.valueOf(produto.getCodigo()))
				.type(MediaType.APPLICATION_JSON)
				.put(ClientResponse.class, produto);
		
		if (resp.getStatus() != 200) {
			throw new Exception("Erro");
		}
	}
	
	public void remover(int codigo) throws Exception {
		ClientResponse resp = resource
				.path(String.valueOf(codigo))
				.delete(ClientResponse.class);
		
		if (resp.getStatus() != 204) {
			throw new Exception("Erro");
		}
	}
	
	public List<Produto> listar() throws Exception{
		ClientResponse resp = resource
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		if (resp.getStatus() != 200) {
			throw new Exception("Erro");
		}
		
		return Arrays.asList(resp.getEntity(Produto[].class));
	}
	
	public Produto buscar(int codigo) throws Exception {
		ClientResponse resp = resource
				.path(String.valueOf(codigo))
				.accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
				
		if (resp.getStatus() != 200) {
			throw new Exception("Erro");
		}
		
		return resp.getEntity(Produto.class);
	}
}







