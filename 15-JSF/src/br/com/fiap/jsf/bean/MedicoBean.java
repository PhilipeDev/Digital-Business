package br.com.fiap.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fiap.ws.entity.Medico;
import br.com.fiap.ws.service.MedicoService;

@ManagedBean
public class MedicoBean {
	
	private Medico medico;
	private MedicoService service;

	//M�todo que � acionado na cria��o da p�gina
	@PostConstruct
	private void init() {
		medico = new Medico();
		service = new MedicoService();
	}
	
	//Lista de m�dico para a tabela
	public List<Medico> listarMedicos(){		
		try {
			return service.consultarLista();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Medico>();
	}
	
	
	
	public String salvar(){
		FacesMessage msg;
		try {
			//Verificar se � para cadastrar ou atualizar
			if(medico.getCodigo()==0) {
				service.cadastrar(medico);
				msg = new FacesMessage("Cadastrado com sucesso.");	
			}else{
				service.atualizar(medico);
				msg = new FacesMessage("Atualizado com sucesso.");
				return "lista_medicos";  //nome do arquivo da p�gina xhtml
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao listar");
		}
		
		//Adiciona a mensagem para a tela
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "medico"; //nome do arquivo da p�gina xhtml
		
	}
	
	//M�todo do clique do bot�o excluir da listagem
	public void excluir(int codigo) {
		FacesMessage msg;
		try {
			service.remover(codigo);
			msg = new FacesMessage("Removido com sucesso.");	
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao remover.");	
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		
	}
	
	//Getter's and Setter's
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	
}
