public class Candidato {
	private String nome;
	private String partido;
	private int intencoesVotos;
	
	public Candidato(String nome, String partido, int intencoesVotos) { // construtor
		this.nome = nome;
		this.partido = partido;
		this.intencoesVotos = intencoesVotos;
	}
	
	public String getNome() { //gets
		return nome;
	}
	
	public String getPartido() {
		return partido;
	}
	
	public int getIntencoesVotos() {
		return intencoesVotos;
	}
	
	public String toString() { // ToString para printar os dados
		return "Candidato: " + nome + " | Partido: " + partido + " | Votos: " + intencoesVotos;
	}
}
