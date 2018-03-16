package br.com.fiap.ws.service;

import org.apache.axis2.AxisFault;

import br.com.fiap.ws.bo.DisciplinaBOStub;
import br.com.fiap.ws.bo.DisciplinaBOStub.CalcularMedia;
import br.com.fiap.ws.bo.DisciplinaBOStub.CalcularMediaResponse;

public class DisciplinaService {
	
	private DisciplinaBOStub stub;
	
	public DisciplinaService() throws AxisFault {
		stub = new DisciplinaBOStub();
	}
	
	public float calcularMedia(float am, float nac, float ps) throws Exception{
		
		CalcularMedia params = new CalcularMedia();
		params.setAm(am);
		params.setNac(nac);
		params.setPs(ps);
		CalcularMediaResponse resp = stub.calcularMedia(params);
		
		float media = resp.get_return();
		
		return media;
	}
	
}
