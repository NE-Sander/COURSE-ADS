/*
Construa um programa que leia do teclado uma string de até 100 char e que apresente para o
usuário as seguintes opções:
(X) Entrar com nova string
(X) Mostrar a quantidade total de caracteres contidos na string (incluindo letras,
pontuação, espaços etc.)
(X) Converter todas as letras da última string que foi digitada em maiúsculas
(X) Converter todas as letras da última string que foi digitada em minúsculas
(X) Sair do programa

Orientações:
• Todo o programa deve ser construído no main, ou seja, não podem ser usadas
funções separadas porque isso não foi visto nas aulas.
• Você pode usar as funções das bibliotecas string.h e ctype.h
• Após a leitura de uma string e a escolha de uma das opções o usuário pode decidir se
entra com uma nova string, se realiza mais alguma operação com a última string
digitada ou se sai do programa

*/
#include <ctype.h>
#include <stdio.h>
#include <string.h>
#include <windows.h>
#include <unistd.h>



int main() {
    int i;
    char c;
    int opcao = 0;

    char string[101] = ""; // [101] - POIS O ÚLTIMO CARACTER DA STRING TERMINA EM '\0'


    printf("Digite uma string: ");
    i = 0;
    scanf(" "); // SCANF(" "); - PULA ESPAÇOS EM BRANCO ANTES DE LER A STRING

    do
        {
        scanf("%c", &c); // SALVO O A STRING NA CHAR C;
        string[i] = c; // CADA CARACTER SALVO EM UM ESPAÇO I [101]
        i++; // AUTO-INCREMENTO

        }

    while (c != '\n'); // ENQUANTO O ÚLTIMO CARACTER FOR DIFERENTE DE '\0' =
    string[i - 1] = '\0';  // TROCO CARACTER '\n' PARA '\0' - PARA UTILIZAR STRLEN

    while (opcao != 5)
        {
        // EXIBE O CONSOLE COM AS OPÇÕES PARA O USUÁRIO

        system("cls");
        printf("\n=================Console=======================\n");
        printf("| 1 | Inserir uma nova string                 |\n");
        printf("| 2 | Mostrar a quantidade total de caracteres|\n");
        printf("| 3 | Converter todas as letras em maiusculas |\n");
        printf("| 4 | Converter todas as letras em minusculas |\n");
        printf("| 5 | Sair                                    |\n");
        printf("===============================================\n");

        printf("\nEscolha uma opcao: ");
        scanf("%d", &opcao);
        printf("\n");

        switch (opcao)
        {
            case 1:
                // LÊ CARACTER POR CARACTER E SALVA ELES NA STRING
                printf("\nDigite uma string: ");
                i = 0;
                scanf(" "); // PULA OS ESPAÇOS ANTES DA LEITURA
                do
                {
                    scanf("%c", &c);
                    string[i] = c;
                    i++;
                } while (c != '\n');
                string[i - 1] = '\0';
                break;

            case 2:
                printf("\nA string possui %d caracteres", strlen(string));
                sleep(3);
                break;

            case 3: // CONVERTER EM MAIÚSCULO

                // COMO A STRING TERMINA EM  '\0', VOU AUTO INCREMENTANDO I ATÉ ENCONTRAR O FINAL DA STRING

                for (i = 0; string[i] != '\0'; i++)
                {
                    string[i] = toupper(string[i]);
                }
                printf("%s\n", string);
                sleep(3);

                break;

            case 4: // CONVERTER EM MINÚSCULO

                // COMO A STRING TERMINA EM  '\0', VOU AUTO INCREMENTANDO I ATÉ ENCONTRAR O FINAL DA STRING

                for (i = 0; string[i] != '\0'; i++)
                {
                    string[i] = tolower(string[i]);
                }

                printf("%s\n", string);
                sleep(3);

                break;

            case 5: // SAIR
                system("cls");
                break;

            default:
                printf("!Opcao invalida!\n");
                sleep(2);

                break;
        }
        printf("\n");
    }

    return 0;
}
