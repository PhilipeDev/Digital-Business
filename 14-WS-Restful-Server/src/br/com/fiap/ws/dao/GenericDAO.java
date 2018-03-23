package br.com.fiap.ws.dao;

import br.com.fiap.ws.exception.CommitException;

public interface GenericDAO <T,K>{

	void cadastrar(T entidade);
	void atualizar(T entidade);
	void remover(K chave);
	T consultar(K chave);
	
	void commit() throws CommitException;
	void fechar();
}
