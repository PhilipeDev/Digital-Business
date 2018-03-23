package br.com.fiap.ws.service;

import java.util.Scanner;

public class RemoverView {

	
	public static void main(String[] args) {
		Scanner dados = new Scanner(System.in);
		
		//Le o c�digo
		System.out.print("Digite o c�digo do m�dico a ser removido:");
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
