import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Labirinto {
private char[][] tamLabirinto;
	
	// "crie um método chamado criaLabirinto"
	public void criaLabirinto(String filename) {
		try {
			BufferedReader in = new BufferedReader(new FileReader(filename));
			String line = in.readLine();
			int numLinha= 0;
			int numColuna= line.length();
			while(line != null) {
				numLinha++;
				line = in.readLine();
			}
		in.close();	
		 
		tamLabirinto = new char[numLinha][numColuna];
		
		in = new BufferedReader(new FileReader(filename));
		int linha= 0;
		line = in.readLine();
		while (line != null) {
			numColuna = line.length();
			for(int coluna = 0; coluna < numColuna; coluna++){
				tamLabirinto[linha][coluna] = line.charAt(coluna);
			}
			linha++;
			line = in.readLine();
		}
		in.close();
		} catch (IOException e){	
			e.printStackTrace();
		}
	}
	
	public boolean percorreLabirinto(){
		return percLabirinto(0, 0);
	}
	
	private boolean percLabirinto(int linha, int coluna) {
		// Se sair dos limites da linha 
		if (linha < 0 || linha >= tamLabirinto.length) {
			return false;
		}
		// Se sair dos limites da coluna
		if (coluna < 0 || coluna >= tamLabirinto[0].length){
			return false;
		}
		// Se encontrar a saída 'D'
		if (tamLabirinto[linha][coluna] == 'D'){
			return true;
		}
		
		// Se for parede ou já foi visitada
		if(tamLabirinto[linha][coluna] == 'X' || tamLabirinto[linha][coluna] == 'V') {
			return false;
		}
		
		// Posição visitada
		tamLabirinto[linha][coluna] = 'V';
		
		
		// Movimentar nas 4 direções
		if (percLabirinto(linha - 1, coluna)) { // Cima
			return true;
		}
		
		if (percLabirinto(linha, coluna + 1)) { // Direita
			return true;
		}
		
		if (percLabirinto(linha + 1, coluna)) { // Baixo
			return true;
		}
		
		if (percLabirinto(linha, coluna - 1)) { // Esquerda
			return true;
		}
		tamLabirinto[linha][coluna] = ' ';
		
		return false;
	}
	
	public void mostraLabirinto() {
		for(int i = 0; i < tamLabirinto.length; i++) {
			for(int j = 0; j < tamLabirinto[i].length; j++) {
				System.out.print(tamLabirinto[i][j] + " ");
			}
			System.out.println();
		}
	}
	

}



