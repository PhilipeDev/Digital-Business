package br.com.fiap.ws.to;

public class AlunoTO {

	private int rm;
	
	private String nome;
	
	private float media;
	
	public AlunoTO() {
		super();
	}

	public AlunoTO(int rm, String nome, float media) {
		super();
		this.rm = rm;
		this.nome = nome;
		this.media = media;
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getMedia() {
		return media;
	}

	public void setMedia(float media) {
		this.media = media;
	}
	
}
