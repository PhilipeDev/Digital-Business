package br.com.fiap.ws.view;

import java.util.Scanner;

import br.com.fiap.ws.entity.Medico;
import br.com.fiap.ws.service.MedicoService;

public class ConsultarView {

	public static void main(String[] args) {
		Scanner dados = new Scanner(System.in);
		
		System.out.print("Digite o código do médico a ser buscado:");
			int codigo = (dados.nextInt());
			
		try {
			MedicoService service = new MedicoService();
			Medico medico = service.buscar(codigo);
			//Exibir os dados do médico
			System.out.println(medico.getNome());
			System.out.println(medico.getSalario());
			System.out.println(medico.isPlantonista());
			System.out.println("************************");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		dados.close();
	}
}
