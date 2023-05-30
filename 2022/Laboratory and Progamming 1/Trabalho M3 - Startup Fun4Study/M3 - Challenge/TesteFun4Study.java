public class TesteFun4Study{
    public static void main(String[] args){
        int sairEst = 1;
        int sairCity = 1;
        int opcao;
        int alterar;
        
        do{
            System.out.println("+----------Dados da Cidade----------+");
            Cidade city = new Cidade(Teclado.leInt("Codigo: "),Teclado.leString("Descrição: "), Teclado.leString("UF: "));
            
            city.exibeDadosCidade();
            
            do{
                System.out.println("\n\n+-----------Cadastro Estudante---------+\n");
                Estudante estd = new Estudante(city, Teclado.leInt("Código: "),
                Teclado.leString("Nome completo: "), 
                Teclado.leString("Data de nascimento: "),
                Teclado.leString("Email: "), 
                Teclado.leString("Senha: "));         
                
                estd.exibeDadosEstudante();
                
                opcao = Teclado.leInt("Deseja alterar algum dado do sistema? 1-Sim / 2-Não\n");
                if(opcao==1){
                    alterar = Teclado.leInt("Qual dado deseja alterar? \n 1-Nome / 2-Nascimento / 3-Email / 4-Senha / 5-Sair \n");
                    switch(alterar){
                        case 1:
                        estd.setNome(Teclado.leString("Digite seu nome: "));
                        break;
                        
                        case 2: 
                        estd.setDtnasc(Teclado.leString("Digite a data: ")); 
                        break;
                        
                        case 3:
                        estd.setEmail(Teclado.leString("Digite seu email: "));
                        break;
                        
                        case 4:
                        estd.trocarSenha();
                        break;
                        
                        case 5:
                        break;
                        
                        default:
                        System.out.println("Código inválido!\n");
                        break;
                    }
                }
                
                if(city.getQtdEstudantes()>=4){
                  sairEst = Teclado.leInt("Deseja adicionar outro estudante? 0-Não / 1-Sim\n");
                }
            }
            while(sairEst!=0);
            
            sairCity = Teclado.leInt("Deseja sair do sistema? Sair -> 0  / Nova cidade -> 1\n");
        }while(sairCity!=0);
    }
}
