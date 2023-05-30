/* Faça um programa para autoatendimento que permita ao usuário escolher um ou mais itens do cardápio em uma lancheria ou restaurante e que mostre na tela o(s) nome(s) do(s) lanche(s) escolhido(s)
e o valor total a ser pago. Você deve montar um cardápio com no mínimo 5 itens e no máximo 10 itens e definir os preços para cada produto, conforme o exemplo abaixo. Use os comandos switch-case
 e for, while ou do-while. Considere que podem ser escolhidos vários itens por um mesmo cliente. A cada produto escolhido o usuário deve informar se quer ir para o pagamento ou se quer continuar
 comprando. Você não precisa simular a parte referente ao pagamento, apenas apresentar na tela o valor a ser pago e os produtos que foram escolhidos. Após apresentar o valor a ser pago o programa
 deve voltar a aguardar novos clientes */

/* Libs que utilizei */
#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <unistd.h>


int main ()
{
    int opcao, quantidade;  /* Variaveis int -> trabalham em conjunto (opcao selecionada e quantidade da mesma) */
    float preco, preco_total; /* Variaveis float -> utilizadas na operacao para calculo do valor total */

    for(;;) /* Laço FOR -> utilizada no reboot do programa, trabalha em conjunto com o switch case */
    {
        system("cls");
        preco = 0;

        printf ("\n\t=====================================================\n");    /* Printf usado só pela questão visual */
        printf ("\t|            \tRestaurante Dona Fullana            |\n");
        printf ("\t=====================================================\n");
        printf ("\t|               \t|CARDAPIO|                  |\n");
        printf ("\t=====================================================\n");
        printf ("\t|   1 - Cheddar Duplo\t                 R$25.00    |\n");
        printf ("\t|   2 - Picanha\t                         R$45.00    |\n");
        printf ("\t|   3 - Picanha ao molho madeira\t R$55.50    |\n");
        printf ("\t|   4 - Picanha Chimichurri\t         R$60.90    |\n");
        printf ("\t|   5 - Costelinha ao molho barbecue\t R$79.90    |\n");
        printf ("\t|---------------------------------------------------|\n");
        printf ("\t|   6 - Finalizar compra                            |\n");
        printf ("\t=====================================================\n");
        printf ("\n\tSelecione seu pedido: ");
        scanf ("%d", &opcao);

        switch(opcao) /* Switch case = (opcao) -> avalia a variável int e inicia o case (opcao) selecionado */
        {
        case 1:
            system("cls");
            preco = 25.00;
            printf ("\n\n\tVoce selecionou Cheddar Duplo\n\n");
            break;

        case 2:
            system("cls");
            preco = 45.00;
            printf ("\n\n\tVoce selecionou Picanha\n\n");
            break;

        case 3:
            system("cls");
            preco = 55.50;
            printf ("\n\n\tVoce selecionou Picanha ao molho madeira\n\n");
            break;

        case 4:
            system("cls");
            preco = 60.90;
            printf ("\n\n\tVoce selecionou Picanha chimichurri\n\n");
            break;

        case 5:
            system("cls");
            preco = 79.90;
            printf ("\n\n\tVoce selecionou Costelinha ao molho barbecue \n\n");
            break;

        case 6:
            system ("cls");
            printf ("\n\n\tEncerrando a compra. Aguarde 3 segundos...");
            sleep (3);
            system ("cls");
            printf ("\t========================================\n");
            printf ("\t| Valor total da compra: R$%.2f       | \n", preco_total);
            printf ("\t========================================\n\n");
            preco_total = 0;
            sleep (10);                         /* Só por questão visual */
            system ("cls");
            printf ("\n\tMaquina reiniciando, aguarde");
            sleep (1);
            system ("cls");
            printf ("\n\tMaquina reiniciando, aguarde.");
            sleep (1);
            system ("cls");
            printf ("\n\tMaquina reiniciando, aguarde..");
            sleep (1);
            system ("cls");
            printf ("\n\tMaquina reiniciando, aguarde...");
            sleep (1);
            system ("cls");
            printf ("\n\tMaquina reiniciando, aguarde.");
            sleep (1);
            system ("cls");
            printf ("\n\tMaquina reiniciando, aguarde..");
            sleep (1);
            system ("cls");
            printf ("\n\tMaquina reiniciando, aguarde...");
            sleep (1);
            system ("cls");
            printf ("\n\t=============================================\n");
            printf ("\t|       \t|BEM - VINDO|               |\n");
            printf ("\t=============================================\n");
            sleep (3);
            system ("cls");
            break;  /* Reinicializei a máquina e o sistema */

        default:
            system("cls");
            printf("\t=========================================\n");
            printf ("\t|CODIGO INVALIDO! REINICIANDO O PROGRAMA|\n");
            printf("\t=========================================\n\n");
            sleep (5);
            break;

        }

if(opcao >= 1 && opcao <=5) {
    printf ("\n\tSelecione a quantidade: "); /* Printf e Scanf -> Fora do Switch, preciso que retorne fora da seleção de constante */
    scanf("%d", &quantidade);
    printf ("\n");
    preco = quantidade * preco;  /* Operação do valor total */
    preco_total = preco + preco_total; }
    }
}
