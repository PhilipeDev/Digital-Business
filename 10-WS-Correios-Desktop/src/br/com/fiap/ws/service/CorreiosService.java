package br.com.fiap.ws.service;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.tempuri.CalcPrecoPrazoWSStub;
import org.tempuri.CalcPrecoPrazoWSStub.CServico;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazo;
import org.tempuri.CalcPrecoPrazoWSStub.CalcPrazoResponse;

public class CorreiosService {
	
	private CalcPrecoPrazoWSStub stub;
	
	public CorreiosService() throws AxisFault {
		stub = new CalcPrecoPrazoWSStub();
	}
	
	public CServico calcularPrazo(String cepOrigem, String cepDestino) throws RemoteException {
		
		CalcPrazo params = new CalcPrazo();
		params.setNCdServico("04510");
		params.setSCepDestino(cepDestino);
		params.setSCepOrigem(cepOrigem);
		
		CalcPrazoResponse resp = stub.calcPrazo(params);
		
		return resp.getCalcPrazoResult().getServicos().getCServico()[0];
		
		
	}
	
}
