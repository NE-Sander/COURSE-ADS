'''
Construa um programa que simule o funcionamento da máquina de bebidas que você 
especificou no primeiro trabalho. Para simular a inserção de notas ou moedas o usuário deve 
digitar valores no teclado. Você pode, por exemplo, mostrar na tela as seguintes mensagens:

Digite 1 para pagar com moedas de 1,00 real
Digite 2 para pagar com notas de 2,00 reais

Ou ainda, você pode pedir para o usuário digitar o valor total que ele vai inserir (ex.: 4,00 
etc.). Neste trabalho o fornecimento de troco é opcional e pode ser simulado com mensagens 
na tela. Depois que uma venda é finalizada a máquina aguarda outros clientes.
Use estruturas condicionais e comandos de repetição sempre que for necessário
'''
import os
import time


def header():
    os.system('cls')
    print('\n')
    print('=' * 30)
    print('{:^30}'. format('Máquina de bebidas'))
    print('=' * 30)


def valores():
    print('=' * 30)
    print('Digite 1 para adicionar R$ 1.00')
    print('Digite 2 para adicionar R$ 2.00')
    print('=' * 30)


def temp(tempo):
    print('Reiniciando a máquina, aguarde ' + str(tempo) + ' segundos...')
    time.sleep(tempo)
    os.system('cls')
    return main()


def main():

    header()
    produto = ["- Água s/gas", "- Água c/gas", "- Coca-cola", "- Pepsi"]
    valor = 0
    saldo = 0

    for index, prod in enumerate(produto, start=1):
        print(index, prod)

    opcao = int(input('\nSelecione sua bebida: '))

    for index, prod in enumerate(produto, start=1):

        if opcao == index:
            os.system('cls')
            print('\nVocê selecionou ' + prod)

    if opcao == 1 or opcao == 2:
        valor = 3
        print('Esta Bebida custa R$ 3.00 \n')
        valores()

    elif opcao == 3 or opcao == 4:
        valor = 4
        print('Esta Bebida custa R$ 4.00 \n')
        valores()

    else:
        os.system('cls')
        print('Este produto não existe.')
        temp(4)

    while (saldo <= valor):

        if saldo == valor:
            print('Compra realizada com sucesso!\n')
            temp(6)

        moeda = int(input('\nInserir R$ '))
        saldo += moeda

        if moeda > 2 or moeda <= 0:
            print('Desculpe, aceitamos apenas R$1 e R$2 ...')
            temp(4)

        if valor == 3 or valor == 4:
            os.system('cls')

            header()
            valores()

            print('\nSaldo: R$' + str(saldo) + '.00')

        if saldo == 4 and valor == 3:
            print('\nO valor da compra é R$' + str(valor) + '.00 Reais' +
                  ', troco de ' + 'R$' + str(saldo-valor) + '.00 real.')
            saldo = 3
            print('Obrigado pela sua compra!\n')
            temp(6)

        if saldo >= 5 and valor == 4:
            print('\nO valor da compra é R$' + str(valor) + '.00 Reais' +
                  ', troco de ' + 'R$' + str(saldo-valor) + '.00 real.')
            saldo = 4
            print('Obrigado pela sua compra!\n')
            temp(6)

main()
