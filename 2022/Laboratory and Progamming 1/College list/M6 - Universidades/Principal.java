
public class Principal
{
    public static void main(String args[]){
        int quant, opcao; // setando as variaveis 
        quant = Teclado.leInt("Quantas universidades deseja adicionar?: "); // Iniciando a variavel quant para confirmarmos a quantidade utilizada na array
        Universidade [] arrayUni = new Universidade[quant]; // Setamos as linhas utilizadas na array
        
        for(int i=0; i<arrayUni.length; i++){ // Iniciamos o loop para buscar os dados da array
 
            
            System.out.println("\n [1] - Universidade Pública  /  [2] - Universidade Privada");
            opcao = Teclado.leInt("Selecione uma opção: "); // Iniciamos a seleção para entrarmos no switch case

                
            switch(opcao){
                case 1: // Adicionando faculade Publica
                 arrayUni[i] = new Publica (Teclado.leString("Nome da universidade: "), //Iniciamos um objeto da classe Publica para dentro da array
                 Teclado.leInt("Quantidade de alunos: "), 
                 Teclado.leInt("Quantidade de Professores: "),
                 Teclado.leString("Digite o Estado: "),
                 Teclado.leString("Digite a cidade: "));
                 break; // quebramos
                    
                    
                case 2: // Adicionando faculdade Privada
                 arrayUni[i] = new Privada (Teclado.leString("Nome da universidade: "), // Iniciamos um objeto da classe Privada para dentro da array
                 Teclado.leInt("Quantidade de alunos: "), 
                 Teclado.leInt("Quantidade de Professores: "),
                 Teclado.leDouble("Valor da mensalidade: "));
                 break; // quebramos
                    
                default:
                 System.out.println("Opção inválida"); // Default para caso outro número seja digitado e retornamos ao For
            }
        }
        
        MEC mec = new MEC(); // Iniciamos nossa classe Mec para utilizarmos os métodos
        
        System.out.println("\n====Universidades Cadastradas===="); // Método imprimeUniversidades
        mec.imprimeUniversidades(arrayUni);
        
        System.out.println("\n====Univesidade mais cara===="); // Método maisCara
        mec.maisCara(arrayUni);
        
        System.out.println("\n====Universidades públicas da região SUL===="); // Método universidadesDoSul
        mec.universidadesDoSul(arrayUni);
    }
}
