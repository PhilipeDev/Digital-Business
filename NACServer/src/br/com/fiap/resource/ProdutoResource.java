package br.com.fiap.resource;

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

import br.com.fiap.ws.dao.ProdutoDAO;
import br.com.fiap.ws.dao.impl.ProdutoDAOImpl;
import br.com.fiap.ws.entity.Produto;
import br.com.fiap.ws.singleton.EntityManagerFactorySingleton;

@Path("/produto")
public class ProdutoResource {

	private ProdutoDAO dao;
	
	public ProdutoResource() {
		EntityManager em = EntityManagerFactorySingleton
							.getInstance().createEntityManager();
		dao = new ProdutoDAOImpl(em);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Produto produto, @Context UriInfo uri) {
		try {
			dao.cadastrar(produto);
			dao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.serverError().build(); //ERRO 500
		}
		UriBuilder url = uri.getAbsolutePathBuilder();
		url.path(String.valueOf(produto.getCodigo()));
		return Response.created(url.build()).build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Produto produto, @PathParam("id") int id) {
		try {
			produto.setCodigo(id);
			dao.atualizar(produto);
			dao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public void remover(@PathParam("id") int codigo) {
		try {
			dao.remover(codigo);
			dao.commit();
		}catch(Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listar(){
		return dao.listar();
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Produto buscar(@PathParam("id") int codigo) {
		return dao.buscar(codigo);
	}
	
	
}







