package br.com.fiap.ws.view;

import java.util.List;
import java.util.Scanner;

import br.com.fiap.ws.entity.Medico;
import br.com.fiap.ws.service.MedicoService;

public class ConsultarListaView {
	Scanner dados = new Scanner(System.in);
	
	public static void main(String[] args){
		
		MedicoService service = new MedicoService();
		
		try {	
			List<Medico> arrayMedicos = service.consultarLista();
			for(Medico medico:arrayMedicos) {
				System.out.println(medico.getNome());
				System.out.println(medico.getSalario());
				System.out.println(medico.isPlantonista());
				System.out.println("************************");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
}
