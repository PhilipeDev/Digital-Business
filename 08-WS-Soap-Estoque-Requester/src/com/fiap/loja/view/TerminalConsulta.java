package com.fiap.loja.view;

import java.util.Scanner;

import org.apache.axis2.AxisFault;

import com.fiap.loja.bo.EstoqueBOStub;
import com.fiap.loja.bo.EstoqueBOStub.BuscarProduto;
import com.fiap.loja.bo.EstoqueBOStub.BuscarProdutoResponse;
import com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		//Consultar um produto através do web service
		Scanner sc = new Scanner(System.in);
		
		try {
			EstoqueBOStub stub = new EstoqueBOStub();
			//Parametros para o web service
			BuscarProduto params = new BuscarProduto();
			System.out.print("Código do produto: ");
			params.setCodigo(sc.nextInt());
			
			//Chama o web service e obtem a resposta
			BuscarProdutoResponse response = 
									stub.buscarProduto(params);
			
			//Exibe os valores
			ProdutoTO to = response.get_return();
			System.out.println(to.getNome());
			System.out.println(to.getPreco());
			System.out.println(to.getQuantidade());
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}
	
}
