
public class Cidade
{
   private int codigo;
   private String descricao; 
   private String uf;
   private int qtdEstudantes;
   

    public Cidade(int c, String d, String uf){ //METODO CONSTRUTOR
       this.codigo = c;
       this.descricao = d;
       this.uf = uf;
   }

   
   public void exibeDadosCidade (){  //EXIBIR DADOS
       System.out.println("+----------Dados da Cidade----------+");
       System.out.println("Codigo: " + codigo);
       System.out.println("Descrição: " + descricao);
       System.out.println("Uf: " + uf);
       System.out.println("Qtd ESTUDANTES: " + qtdEstudantes);
   }
   
   
   /*
     public void adicionaCidade(){
        System.out.println("+-----------Cadastro Cidade---------+");
        codigo = Teclado.leInt("Codigo: ");
        descricao = Teclado.leString("Descrição: ");
        uf = Teclado.leString("UF: ");
    }
    */
   
    public void adicionaNovoEstudante (){ //AUTO INCREMENT ++ PARA ADICIONAR ESTUDANTES
       qtdEstudantes++;
    }
   
   public int getQtdEstudantes(){
       return qtdEstudantes;
   }
    
   public int getCodigo(){
       return codigo;
   }

   public String getDescricao(){
       return descricao;
   }
   public void setDescricao(String d){
       descricao = d; 
   }
   
   public String Uf(){
       return uf;
   }
   public void setUf(String uf){
       uf = uf;
   }
}
