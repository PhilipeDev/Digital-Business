package br.com.fiap.ws.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.ws.entity.Medico;

public class MedicoService {

	private Client client;
	
	//Construtor para inicializar o client ao ser instanciado
	public MedicoService() {
		client = Client.create();
	}
	
	//Constante com a URL
	private static final String URL = "http://localhost:8080/12-WS-Restful-Server/rest/medico";
	
	//M�todo de cadastrar @POST
	public void cadastrar(Medico medico) throws Exception {
			//Cadastrar o m�dico atrav�s do webservice
				WebResource resource = 
						client.resource(URL);
					//Tipo de dado aceito
				ClientResponse response = 
						//Envia o JSON
						resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, medico);
				
				//Validar o HTTP Status Code 201 created
				if(response.getStatus() != 201) {
					throw new Exception("Erro - HTTP Status: " + response.getStatus());
				}
	}
	
	
	//M�todo de consultar lista de medicos @GET
	public List<Medico> consultarLista() throws Exception{
		WebResource resource = 
				client.resource(URL);
		
		ClientResponse response = 
				//Recebe o JSON atr�ves da requisi��o GET
				resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
	
		List<Medico> medicos = new ArrayList<>();
		
		if(response.getStatus() != 200) {
			throw new Exception("Erro ao consultar a lista de m�dicos - HTTP Status: " + response.getStatus());
			
		}
		
		Medico[] array = response.getEntity(Medico[].class);
		
		return Arrays.asList(array); 
	}
	
	//M�todo de consultar com id @GET
	public Medico buscar(int codigo) throws Exception {
		WebResource resource = 
				client.resource(URL).path(String.valueOf(codigo));
		
		ClientResponse response = 
				resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		if(response.getStatus() != 200) {
			throw new Exception("Erro ao consultar o m�dico - HTTP Status: "+ response.getStatus());
		}
		
		return response.getEntity(Medico.class);
	}
	
	//M�todo de atualizar @PUT
	public void atualizar(Medico medico) throws Exception {
		
		WebResource resource = client.resource(URL)
				//C�digo do m�dico que ser� atualizado
				.path(String.valueOf(medico.getCodigo()));
		
		//@PUT - Atualizando
		ClientResponse response = 
				resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, medico);
	
		if(response.getStatus() != 200) {
			throw new Exception("Erro ao atualizar o m�dico - HTTP Status: "+ response.getStatus());
		}
		
	}
	
	//M�todo de remover
	public void remover(int codigo) throws Exception {
		WebResource resource = client.resource(URL)
				//C�digo do m�dico que ser� removido
				.path(String.valueOf(codigo));
		
		ClientResponse response = resource.delete(ClientResponse.class);
		
		if(response.getStatus() != 204) {
			throw new Exception("Erro ao remover o m�dico - HTTP Status:"+ response.getStatus());
		}
	}
	
}
