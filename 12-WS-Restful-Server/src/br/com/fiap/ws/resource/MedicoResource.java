package br.com.fiap.ws.resource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import br.com.fiap.ws.dao.MedicoDAO;
import br.com.fiap.ws.dao.impl.MedicoDAOImpl;
import br.com.fiap.ws.entity.Medico;
import br.com.fiap.ws.exception.CommitException;
import br.com.fiap.ws.exception.IdNotFoundException;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/medico")
public class MedicoResource {
	
	//Váriavel do dao para ser utilizada na classe.
	private MedicoDAO dao;
	
	//Construtor onde implementará o dao passando o entityManager
	public MedicoResource() {
		EntityManager em = 
				EntityManagerFactorySingleton.getInstance().createEntityManager();
		dao = new MedicoDAOImpl(em);
	}
	
	//Método GET retorna parametros em sua URL
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	
	
	//Buscar
	public Medico buscar(@PathParam("id") int codigo) {
		
		return dao.buscar(codigo);
		
	}
	
	//Método POST não retorna parametros em sua URL
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	
	
	//Cadastrar
	//Ao utilizar o post esperamos o código HTTP 201(Created)
	public Response cadastrar(Medico medico, 
			@Context UriInfo url){
		//O @Context ira retornar as informações atualizadas
		try {
			dao.cadastrar(medico);
			dao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		//Criar a URL que exibe o medico cadastrado
		UriBuilder b = url.getAbsolutePathBuilder();
		
		//Caminho do código do médico cadastrado
		b.path(String .valueOf(medico.getCodigo()));
		
		return Response.created(b.build()).build();
	}
	
	
	//Buscar todos os medicos
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Medico> listarMedicos() {
		
		return dao.listar();
		
	}
	
	//Atualizar
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Medico medico, @PathParam("id") int codigo) {
		
		try {
			medico.setCodigo(codigo);
			dao.atualizar(medico);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	
		return Response.ok().build();
		
	}
	
	
	//Remover
	@DELETE
	@Path("{id}")
	public void remover(@PathParam("id")int codigo) throws CommitException{
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
}
