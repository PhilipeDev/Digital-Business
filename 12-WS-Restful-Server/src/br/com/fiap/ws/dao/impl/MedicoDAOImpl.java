package br.com.fiap.ws.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.ws.dao.MedicoDAO;
import br.com.fiap.ws.entity.Medico;

public class MedicoDAOImpl extends GenericDAOImpl<Medico, Integer> implements MedicoDAO{

	public MedicoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
}
