package br.com.fiap.ws.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.ws.dao.GenericDAO;
import br.com.fiap.ws.exception.CommitException;

public class GenericDAOImpl<T, K> implements GenericDAO{

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz = (Class<T>)
				((ParameterizedType) 
					getClass().getGenericSuperclass())
								.getActualTypeArguments()[0];
	}
	
	
	@Override
	public void cadastrar(Object entidade) {
		em.persist(entidade);
		
	}

	@Override
	public void atualizar(Object entidade) {
		// TODO Auto-generated method stub
		em.merge(entidade);
	}

	@Override
	public void remover(Object chave) {
		// TODO Auto-generated method stub
		em.remove(chave);
	}

	@Override
	public Object consultar(Object chave) {

		return em.find(clazz, chave);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
				e.printStackTrace();
				throw new CommitException("Erro ao realizar o commit");
			}
		}
		
	}

	@Override
	public void fechar() {
		// TODO Auto-generated method stub
		
	}

}
