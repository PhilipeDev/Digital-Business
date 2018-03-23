package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.entity.Medico;
import br.com.fiap.ws.service.MedicoService;

public class CadastrarView {
	
	public static void main(String[] args) {
		Scanner dados = new Scanner(System.in);
		
		//Ler os dados do médico
		Medico medico = new Medico();
		String escolha ;
		
		//Na classe client devemos ter os mesmos atributos do objeto do server.
		System.out.print("Digite o nome do médico:");
			medico.setNome(dados.next() + dados.nextLine());
		System.out.print("Digite o salário do médico:");
			medico.setSalario(dados.nextDouble());
		System.out.print("Digite se o médico é plantonista [S/N]:");
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
