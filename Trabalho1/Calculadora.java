package Trabalho1;

import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        char tipo = 'a';
        String expressao = " ";
        System.out.println("Insira a expressão pós fixa");
        Scanner teclado = new Scanner(System.in);
        expressao = teclado.next();
        while (tipo != 'e' && tipo != 'E' && tipo != 'd' && tipo != 'D') {
            System.out.println("Digite 'E' para usar a pilha estática ou 'D' para a pilha dinâmica");
            tipo = teclado.next().charAt(0);

            if (tipo != 'e' && tipo != 'E' && tipo != 'd' && tipo != 'D') {
                System.out.println("Deve ser digitado 'E' ou 'D', tente novamente");
            }
        }

        System.out.println(tipo);
    }
}
