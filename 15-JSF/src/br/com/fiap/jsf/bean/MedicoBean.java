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

	//Método que é acionado na criação da página
	@PostConstruct
	private void init() {
		medico = new Medico();
		service = new MedicoService();
	}
	
	//Lista de médico para a tabela
	public List<Medico> listarMedicos(){		
		try {
			return service.consultarLista();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Medico>();
	}
	
	public void cadastrar(){
		FacesMessage msg;
		try {
			service.cadastrar(medico);
			msg = new FacesMessage("Cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro ao listar");
		}
		
		//Adiciona a mensagem para a tela
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
