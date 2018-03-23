package br.com.fiap.ws.service;

import java.util.Scanner;

public class RemoverView {

	
	public static void main(String[] args) {
		Scanner dados = new Scanner(System.in);
		
		//Le o código
		System.out.print("Digite o código do médico a ser removido:");
			int codigo = dados.nextInt();
			
		//Chama o webservice para apagar
		MedicoService service = new MedicoService();
		
		try {
			service.remover(codigo);
			System.out.println("Removido com sucesso.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		dados.close();
	}
}
