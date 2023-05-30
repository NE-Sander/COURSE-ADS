public class Estudante
{
    private int codigo;
    private String nome, dtnasc, email;
    private Cidade cidade;
    private String senhaPadrao="root";
    private String senhaEstudante, senhaNova, senhaNovac;    
    
    public Estudante(Cidade cidade, int codigo, String nome, String dtnasc, String email, String senha){
        this.cidade = cidade;
        this.codigo = codigo;
        this.nome = nome;
        this.dtnasc = dtnasc;
        this.email = email;
        this.senhaEstudante = senha;
        
        cidade.adicionaNovoEstudante();
    }
    
    /*
    public void adicionaEstudante(){
        System.out.println("\n\n+-----------Cadastro Estudante---------+\n");
        codigo = Teclado.leInt("Código: ");
        nome = Teclado.leString("Nome completo: ");
        dtnasc = Teclado.leString("Data de nascimento: ");
        email = Teclado.leString("Email: ");
    }
    */
    
    public void validarSenha(){
       senhaEstudante = Teclado.leString("Digite sua senha PADRAO: ");
       if(senhaEstudante.equals((senhaPadrao))){
           do{
               senhaNova = Teclado.leString("Digite sua nova senha: ");
               senhaNovac = Teclado.leString("Digite a senha novamente: ");
               if(senhaNova.equals((senhaNovac))){
                   System.out.println("Senha atualizada com sucesso!");
                   senhaEstudante = senhaNovac;

               }else{
                   System.out.println("As senhas não coincidem. Tente novamente!");
               }
            }while(!senhaNovac.equals((senhaNova)));
        }else{
        System.out.println("Senha errada. Tente novamente");
        senhaEstudante = senhaPadrao;
        }
    }
    
    public void trocarSenha(){
       String senhaAnterior = Teclado.leString("Digite sua senha anterior: ");
       if(senhaAnterior.equals((senhaEstudante))){
           do{
               senhaNova = Teclado.leString("Digite a NOVA senha: ");
               senhaNovac = Teclado.leString("Digite a senha novamente: ");
               if(senhaNova.equals((senhaNovac))){
                   System.out.println("Senha atualizada!");
                   senhaEstudante = senhaNovac;
               }else{
                   System.out.println("As senhas não coincidem. Tente novamente-!");
               }
            }while(!senhaNovac.equals((senhaNova)));
        }else{
        System.out.println("Senha digitada errada. Tente novamente");
        senhaEstudante = senhaPadrao;
        }
    }
    
    public void exibeDadosEstudante(){
        System.out.println("\n\n+----------Dados do Estudante----------+\n");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dtnasc);
        System.out.println("Email: " + email);
        System.out.println("Senha: " + senhaEstudante);
    }
    
    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int c){
        codigo = c;
    }
    //
    public String getNome(){
        return nome;
    }
    public void setNome(String n){
        nome = n;
    }
    //
    public String getDtnasc(){
        return dtnasc;
    }
    public void setDtnasc(String dtnasc){
        dtnasc = dtnasc;
    }
    //
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        email = email;
    }
    //
    public Cidade getCidade(){
        return cidade;
    }
    public void setCidade(Cidade cidade){
        cidade = cidade;
    }
}
