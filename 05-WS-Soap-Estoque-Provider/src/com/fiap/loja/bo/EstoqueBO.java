package com.fiap.loja.bo;

import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;

import com.fiap.loja.to.ProdutoTO;

/**
 * Classe de negócio que controla o estoque da empresa
 * @author Thiago Yamamoto
 * @version 1.0
 */
public class EstoqueBO {

	public List<ProdutoTO> listar(){
		List<ProdutoTO> lista = new ArrayList<>();
		lista.add(new ProdutoTO(401, "Camiseta Masculina", 100, 5));
		lista.add(new ProdutoTO(402, "Camiseta Feminina", 50, 4));
		return lista;
	}
	
	/**
	 * Pesquisa um produto em estoque
	 * @param codigo
	 * 	Código do produto
	 * @return Produto
	 * @throws AxisFault 
	 */
	public ProdutoTO buscarProduto(int codigo) throws AxisFault {
		ProdutoTO produto = null;
		switch (codigo) {
		case 401:
			produto = new ProdutoTO(401, 
					"Camiseta Masculina Manga Curta Branca", 40, 10);
			break;
		case 402:
			produto = new ProdutoTO(402, 
					"Camiseta Feminina Manga Longa Rosa", 50, 20);
			break;
		default:
			throw new AxisFault("Produto não cadastrado");
		}
		return produto;
	}
	
}


