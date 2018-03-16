package br.com.fiap.view;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CServico;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class ConsoleView {

	//04014 (Sedex)
	public static void main(String[] args) {
		//Calcular o prazo de entrega
		Scanner sc = new Scanner(System.in);
		 
		try {
			CalcPrecoPrazoWSStub stub = new CalcPrecoPrazoWSStub();
			
			//Valores para enviar para o web service
			CalcPrazo parametros = new CalcPrazo();
			parametros.setNCdServico("04510");
			System.out.print("CEP de Origem: ");
			parametros.setSCepOrigem(sc.next()+sc.nextLine());
			System.out.print("CEP de Destino: ");
			parametros.setSCepDestino(sc.next()+sc.nextLine());

			//Chama o web service e recupera a resposta
			CalcPrazoResponse resp = stub.calcPrazo(parametros);
			
			//Recupera as informações da resposta do ws
			CServico servico = resp.getCalcPrazoResult()
					.getServicos().getCServico()[0];
			System.out.println("Prazo: " +servico.getPrazoEntrega());
			System.out.println("Data Máxima: " + servico.getDataMaxEntrega());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
}



