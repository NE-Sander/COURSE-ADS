
public class Main {
    public static void main(String[] args) {
        Labirinto labirinto = new Labirinto();
        labirinto.criaLabirinto("A:\\ws-Eclipse\\Etapa_1_Labirinto\\Labirinto TXT\\filename.txt");
        if (labirinto.percorreLabirinto()) {
            System.out.println("Saída encontrada!");
            labirinto.mostraLabirinto();
        } else {
            System.out.println("Saída não encontrada");
        }
        
    }
}