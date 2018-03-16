package br.com.fiap.ws.bo;

import org.apache.axis2.AxisFault;

import br.com.fiap.ws.to.AlunoTO;

public class AlunoBO {

	public AlunoTO pesquisarAluno(int codigo) throws AxisFault {
		if (codigo == 254) {
			return new AlunoTO(254,"Cassio",10);
		}else if (codigo == 255) {
			return new AlunoTO(255,"Alexandre",6);
		}else {
			throw new AxisFault("Aluno não encontrado");
		}
	}
	
}
