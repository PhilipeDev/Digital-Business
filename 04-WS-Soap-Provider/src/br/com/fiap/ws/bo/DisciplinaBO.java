package br.com.fiap.ws.bo;

public class DisciplinaBO {

	public float calcularMedia(float nac, float am, float ps) {
		return nac*0.2f + am*0.3f + ps*0.5f;
	}
	
	public float calcularQuantoTirarPS(float nac, float am) {
		return (6-nac * 0.2f - am*0.3f)*2;
	}
	
	public float calcularPassarAno(float nac, 
							float am, float media1Semestre) {
		return (12 - media1Semestre - nac*0.2f - am*0.3f)*2;
	}
	
}
