import java.util.Random;
import java.util.Scanner;

public class PrincipalCandidatos {

	public static void main(String[] args) {
	
		Random aleatorio = new Random(); // variavel pra usar o número aleatório
		Scanner scan = new Scanner(System.in); // scanner pra ler o teclado
		int arrayCandidato = aleatorio.nextInt(101); // Variavel para o número 1 a 100
		Candidato[] candidatoA = new Candidato[arrayCandidato]; // Criando objeto da classe Candidato
		
		for (int i = 0; i < arrayCandidato; i++) { // Percorrer o ARRAY + Adicionar os valores nos atributos
			String nome = nomeAleatorio();
			String partido = partidoAleatorio();
			int intenVotos = aleatorio.nextInt(101);
            candidatoA[i] = new Candidato(nome, partido, intenVotos);
		}
		
		// Ordena por nome -------------------------------------------------
		ordenaCandidatoPorNome(candidatoA);
		System.out.println("\n========= Candidatos (por nome) =========");
		for (Candidato candidato : candidatoA) {
			System.out.println(candidato);
		}
		
		// Ordena por voto --------------------------------------------------
		ordenaCandidatoPorVoto(candidatoA);
		System.out.println("\n\n========= Candidatos (por voto) =========");
		for(Candidato candidato : candidatoA) {
			System.out.println(candidato);
		}
		
		// Ordena por partido -----------------------------------------------
		ordenaCandidatoPorPartido(candidatoA);
		System.out.println("\n\n========= Candidatos (por partido) =========");
		for(Candidato candidato : candidatoA) {
			System.out.println(candidato);
		}
		System.out.println(""); // Para ter espaçamento do toString
		
		// Saída para printar os candidatos ---------------------------------------------
		for (Candidato candidato : candidatoA) { 
			System.out.println(candidato);
		}
		
		// Pesquisa Binaria ------------------------------------------------------------
		System.out.println("\nDigite o nome do candidato: ");
		String nomePesquisado = scan.nextLine();
		int posicao = pesquisaBinariaCandidatos(candidatoA, nomePesquisado);
		if(posicao != -1) {
			System.out.println("Posição do candidato: " + posicao);
			System.out.println(candidatoA[posicao]);
		} 
		else {
			System.out.println("Não foi possível encontrar este candidato!");
		}
		scan.close();
	}// FIM MAIN

	private static String nomeAleatorio() { // Criando o metoodo com os nomes e aleatorizar eles 
		String[] nome = {"Felipe", "Maria", "Junior", "Carla", "Pedro", "Eduardo", "Mirella"};
		Random aleatorioN = new Random();
		return nome[aleatorioN.nextInt(nome.length)];
		
	}
	
	private static String partidoAleatorio() {
		String[] partido = {"AAA", "AAB", "AAC", "ABB", "ABC", "ACC", "ACB"};
		Random aleatorioP = new Random();
		return partido[aleatorioP.nextInt(partido.length)];
		}
	
	private static void ordenaCandidatoPorNome(Candidato [] candidato) { // Ordenando candidatos
		for (int i = 1; i < candidato.length; i++) { // percorrer array
			Candidato chave = candidato[i]; // nome chave específico
			int j = i - 1; // procurando
			while (j>= 0 && candidato[j].getNome().compareTo(chave.getNome()) > 0){ // comparando nomes
				candidato[j + 1] = candidato[j]; //
				j-=1;
			}
			candidato[j+1] = chave;
		}
	}
	
	private static void ordenaCandidatoPorVoto(Candidato[] candidato) { // Ordenando por votos
		for (int i = 1; i < candidato.length; i++) { // percorre array
			Candidato chave = candidato[i]; //
			int j = i - 1;
			while (j>= 0 && candidato[j].getIntencoesVotos() < chave.getIntencoesVotos()) {
				candidato[j + 1] = candidato[j];
				j-=1;
			}
			candidato[j+1] = chave;
		}
	}
	
	private static void ordenaCandidatoPorPartido(Candidato[] candidato) { // Ordenando por partido
		for (int i = 1; i < candidato.length; i++) { // array
			Candidato chave = candidato[i]; 
			int j = i - 1;
			while (j >= 0 && candidato[j].getPartido().compareTo(chave.getPartido()) > 0) { // comparando os partidos
				candidato[j + 1] = candidato[j]; 
				j--;
			}
			candidato[j + 1] = chave;
		}
	}
	private static int pesquisaBinariaCandidatos(Candidato[] candidato, String nomePesquisa) {
		int in = 0;
		int end = candidato.length - 1;
		while (in <= end) {
			int mid = (in + end)/2;
			int comparacao = candidato[mid].getNome().compareTo(nomePesquisa);
			if (comparacao == 0) {
				return mid;
			}
			else if (comparacao < 0) {
				in =  mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	
	
}
