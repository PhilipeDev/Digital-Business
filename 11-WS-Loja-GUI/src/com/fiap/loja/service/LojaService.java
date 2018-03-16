package com.fiap.loja.service;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import com.fiap.loja.bo.EstoqueBOStub;
import com.fiap.loja.bo.EstoqueBOStub.BuscarProduto;
import com.fiap.loja.bo.EstoqueBOStub.BuscarProdutoResponse;
import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class LojaService {
	
	private EstoqueBOStub stub;
	
	public LojaService() throws AxisFault {
		stub = new EstoqueBOStub(); 
	}
	
	public ProdutoTO consultarProduto(int cdProduto) throws RemoteException {
		
		BuscarProduto params = new BuscarProduto();
		params.setCodigo(cdProduto);
		
		BuscarProdutoResponse resp = stub.buscarProduto(params);
		ProdutoTO to = resp.get_return();
		
		return to;
	}
	
}
