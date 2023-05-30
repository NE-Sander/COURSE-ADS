public class MEC
{  
   
   //Universidade [] universidades;
    
   public void imprimeUniversidades(Universidade [] arrayUni){ // Inicio do método para printarmos as faculdades, juntamente ao inicio da array
       for(int i=0; i< arrayUni.length; i++){ // Percorre toda nossa array (ArrayUni)
           if (arrayUni[i] instanceof Privada) { // Se os dados da arrayUni pertencerem a classe Privada vai printar as informações das mesmas 
               System.out.println("\n==Universidade privada=="); 
               arrayUni[i].imprimeInfo();
               System.out.println(" ");
           }
           
           else if (arrayUni[i] instanceof Publica){ // Se os dados da arrayUni pertencerem a classe Publica vai printar as informações das mesmas 
               System.out.println("\n==Universidade publica=="); 
               arrayUni[i].imprimeInfo();
               System.out.println(" ");
           }
       }
   }
   
   public void maisCara(Universidade [] arrayUni){  // Método que calcula qual das faculdades privadas é a mais cara, inicio da array
       double maiorValor = 0; //Variavel para controlarmos o valor
       Privada mCara = null; //Variavel para calcular através da classe Privada
       boolean nenhuma = true; // Variavel de controle do print
       
       for(int i=0; i< arrayUni.length; i++){ // Percorremos a array 
           if(arrayUni[i] instanceof Privada){ // Se os dados pertencerem a classe Privada
               if(((Privada)arrayUni[i]).getValorMensalidade() > maiorValor){ // Pegamos o valor da mensalidade (via teclado) e comparamos com o maior valor 
               nenhuma = false; // mantemos a variavel de controle
               maiorValor = ((Privada)arrayUni[i]).getValorMensalidade(); // Igualamos o valor maior com o valor da mensalidade para reiniciarmos o loop para comparar novamente
               mCara = (Privada)arrayUni[i]; // setamos o maior da array como a variavel mCara
               }
           }
       }
       if(nenhuma){ // Variavel de controle para caso nenhuma das faculdades forem privadas
           System.out.println("Nenhum valor foi encontrado!");
       }
       else{ // Se não for pública, será privada, logo imprimimos o valor a mais cara
           mCara.imprimeInfo(); 
       }
   }

   public void universidadesDoSul(Universidade [] arrayUni){ // Inicio do método que printa as faculdades do sul 
       boolean nenhumaSul = true; // Variavel para controlarmos se alguma das faculdades são da região sul
       for(int i=0; i<arrayUni.length; i++){ // Método que percorre a array
           if(arrayUni[i] instanceof Publica){ // Se o conteúdo da array (arrayUni) pertecer à classe Publica 
               if(((Publica) arrayUni[i]).getEstado().toUpperCase().equals("RS")|| // Verificando as regiões + toUpperCase para caso for escrito maiuscula ou minuscula
                   ((Publica) arrayUni[i]).getEstado().toUpperCase().equals("SC")||
                       ((Publica) arrayUni[i]).getEstado().toUpperCase().equals("PR")){
                nenhumaSul = false; // Setando a variável para controle como falsa, que vai ser verificada novamente próximo if 
                arrayUni[i].imprimeInfo(); // Imprime as informações sobre a/as faculdades do sul que foram alocadas na arrayUni
               }
           }
       }
       if(nenhumaSul){  //Verifica se a variavel de controle é verdadeira, se for, printa que não foi encontrado nenhuma faculdade
           System.out.println("A faculdade não foi encontrada para esta região"); 
       }
   }
}
