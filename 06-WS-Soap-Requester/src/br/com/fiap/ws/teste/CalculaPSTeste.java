package br.com.fiap.ws.teste;

import java.util.Scanner;

import br.com.fiap.ws.bo.DisciplinaBOStub;
import br.com.fiap.ws.bo.DisciplinaBOStub.CalcularQuantoTirarPS;
import br.com.fiap.ws.bo.DisciplinaBOStub.CalcularQuantoTirarPSResponse;

public class CalculaPSTeste {

	public static void main(String[] args) throws Exception {
		//Ler a media de NAC e nota de AM 
		DisciplinaBOStub stub = new DisciplinaBOStub();
		
		Scanner sc = new Scanner(System.in);	
		
		//Chamar o webservice
		CalcularQuantoTirarPS valores = new CalcularQuantoTirarPS();
		System.out.print("Digite a nota de AM: ");
		valores.setAm(sc.nextFloat());
		System.out.print("Digite a média de NAC: ");
		valores.setNac(sc.nextFloat());
		
		//Exibi a nota de PS necessária
		CalcularQuantoTirarPSResponse resposta = 
				stub.calcularQuantoTirarPS(valores);
		
		System.out.println("Você precisa de : " + 
								resposta.get_return());
		
		sc.close();
	}
	
}
