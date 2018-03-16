package br.com.fiap.ws.teste;

import org.apache.axis2.AxisFault;
import br.com.fiap.ws.bo.DisciplinaBOStub;
import br.com.fiap.ws.bo.DisciplinaBOStub.CalcularMedia;
import br.com.fiap.ws.bo.DisciplinaBOStub.CalcularMediaResponse;

public class CalcularMediaTeste {

	public static void main(String[] args) throws Exception {
		
		DisciplinaBOStub stub = new DisciplinaBOStub();
		
		//Valores que serão enviados para o WS
		CalcularMedia parametros = new CalcularMedia();
		parametros.setNac(10);
		parametros.setAm(10);
		parametros.setPs(2);
		
		//Chama o WS e recupera a resposta
		CalcularMediaResponse resposta =
							stub.calcularMedia(parametros);
		
		//Exibe o valor retornado pelo WS
		System.out.println(resposta.get_return());
		
	}
	
}
