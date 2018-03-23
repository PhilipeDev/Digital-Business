package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.entity.Medico;
import br.com.fiap.ws.service.MedicoService;

public class CadastrarView {
	
	public static void main(String[] args) {
		Scanner dados = new Scanner(System.in);
		
		//Ler os dados do m�dico
		Medico medico = new Medico();
		String escolha ;
		
		//Na classe client devemos ter os mesmos atributos do objeto do server.
		System.out.print("Digite o nome do m�dico:");
			medico.setNome(dados.next() + dados.nextLine());
		System.out.print("Digite o sal�rio do m�dico:");
			medico.setSalario(dados.nextDouble());
		System.out.print("Digite se o m�dico � plantonista [S/N]:");
			escolha = (dados.next() + dados.nextLine());
		if(escolha.equalsIgnoreCase("S")) {
			medico.setPlantonista(true);
		}else if(escolha.equalsIgnoreCase("N")) {
			medico.setPlantonista(false);
		}
		System.out.println("");
		System.out.println("*--------------------------------------*");
		
		
		MedicoService service = new MedicoService();
		
		try {
			service.cadastrar(medico);
			System.out.println("Cadastrado!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		dados.close();
	}
	
}
