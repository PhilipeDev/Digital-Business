package br.com.fiap.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImpostoBO {
	
	private static final Logger log = 
			LoggerFactory.getLogger(ImpostoBO.class);
	
	public double calcularIPVA(double valor) throws Exception {
		
		if(valor < 0) {
			log.error("Valor inválido para calculo do IPVA");
			throw new Exception("Valor inválido");
		}
		
		double ipva = valor * 0.06;
		log.info("Calculando valor do IPVA " + valor);
		return ipva;
	}
	
	public double calcularIPTU(double valor) {
		double iptu = valor * 0.005;
		log.trace("Calculando o valor do IPTU " + valor);
		return iptu;
	}
}
