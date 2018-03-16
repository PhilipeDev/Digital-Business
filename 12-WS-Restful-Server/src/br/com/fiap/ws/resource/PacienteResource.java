package br.com.fiap.ws.resource;

import java.net.URI;
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

import br.com.fiap.ws.dao.PacienteDAO;
import br.com.fiap.ws.dao.impl.PacienteDAOImpl;
import br.com.fiap.ws.entity.Paciente;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;


@Path("/paciente")
public class PacienteResource {
	
	//Váriavel do dao para ser utilizada na classe.
	private PacienteDAO dao;
	
	//Construtor onde implementará o dao passando o entityManager
	public PacienteResource() {
		EntityManager em = 
					EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		dao = new PacienteDAOImpl(em);
	}
	
	
	//Cadastrar paciente
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Paciente paciente , @Context UriInfo url) {
		try {
			dao.cadastrar(paciente);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		//Criar a URL que exibe o medico cadastrado
		UriBuilder b = url.getAbsolutePathBuilder();
		
		//Caminho do código do médico cadastrado
		b.path(String.valueOf(paciente.getCodigo()));
		
		return Response.created(b.build()).build();	
	}
	
	
	//Buscar paciente
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Paciente buscar(@PathParam("id") int codigo) {
		
		return dao.buscar(codigo);
		
	}
	
	
	//Listar pacientes
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Paciente> buscar(){
		
		return dao.listar();
	}
	
	
	//Atualizar paciente
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(Paciente paciente, @PathParam("id") int codigo) {
		
		try {
			paciente.setCodigo(codigo);
			dao.atualizar(paciente);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
		return Response.ok().build();
		
	}
	
	//Remover paciente
	@DELETE
	@Path("{id}")
	public void remover(@PathParam("id") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
