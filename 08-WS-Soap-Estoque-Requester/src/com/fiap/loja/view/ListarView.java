package com.fiap.loja.view;

import java.util.Arrays;
import java.util.List;

import com.fiap.loja.bo.EstoqueBOStub;
import com.fiap.loja.bo.EstoqueBOStub.Listar;
import com.fiap.loja.bo.EstoqueBOStub.ListarResponse;
import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class ListarView {

	public static void main(String[] args) {
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			Listar params = new Listar();
			ListarResponse resp = stub.listar(params);
			
			ProdutoTO[] array = resp.get_return();
			//Converter o array em lista
			List<ProdutoTO> lista = Arrays.asList(array);
			
			for (ProdutoTO p : lista) {
				System.out.println(p.getNome());
				System.out.println(p.getPreco());
				System.out.println(p.getQuantidade());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}



