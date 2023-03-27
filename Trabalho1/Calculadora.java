import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        char tipo = 'a';
        String expressao = " ";
        System.out.println("Insira a expressao pos fixa");
        Scanner teclado = new Scanner(System.in);
        expressao = teclado.next() + teclado.nextLine();
        while (tipo != 'e' && tipo != 'E' && tipo != 'd' && tipo != 'D') {
            System.out.println("Digite 'E' para usar a pilha estática ou 'D' para a pilha dinâmica");
            tipo = teclado.next().charAt(0);

            if (tipo != 'e' && tipo != 'E' && tipo != 'd' && tipo != 'D') {
                System.out.println("Deve ser digitado 'E' ou 'D', tente novamente");
            }
        }
        teclado.close();

        Pilha<Double> pilha;
        switch (tipo) {
            case 'e':
                pilha = new PilhaVetor<>();
                break;
            case 'E':
                pilha = new PilhaVetor<>();
                break;
            case 'd':
                pilha = new PilhaLista<>();
                break;
            case 'D':
                pilha = new PilhaLista<>();
                break;
            default:
                pilha = new PilhaLista<>();
        }

        String[] elementos = expressao.split(" ");
        int j = 0;
        int qtdeOperadores = 0;
        int qtdeNumeros = 0;
        while (j < elementos.length) {
            if (!elementos[j].equals("-") && !elementos[j].equals("+") && !elementos[j].equals("*")
                    && !elementos[j].equals("/")) {
                qtdeNumeros++;
            }
            if (elementos[j].equals("-") || elementos[j].equals("+") || elementos[j].equals("*")
                    || elementos[j].equals("/")) {
                qtdeOperadores++;
            }
            j++;
        }

       
            if (elementos.length < 3) {
                throw new IllegalArgumentException(
                        "Expressao incorreta. Sao necessarios pelo menos 3 elementos para calcular.");
            }
            if (qtdeOperadores > qtdeNumeros - 1) {
                throw new IllegalArgumentException("Expressao incorreta. Ha operadores em excesso.");
            }
            if (qtdeOperadores < qtdeNumeros - 1) {
                throw new IllegalArgumentException("Expressao incorreta. Ha operandos em excesso.");
            }

        

        int i = 0;
        Double primeiroNum = 0.0;
        Double segundoNum = 0.0;
        while (i < elementos.length) {
            if (!elementos[i].equals("-") && !elementos[i].equals("+") && !elementos[i].equals("*")
                    && !elementos[i].equals("/")) {
                pilha.push(Double.valueOf(elementos[i]));
            } else {
                if (elementos[i].equals("/")) {
                    segundoNum = pilha.pop();
                    primeiroNum = pilha.pop();
                    pilha.push(primeiroNum / segundoNum);
                } else {
                    if (elementos[i].equals("+")) {
                        segundoNum = pilha.pop();
                        primeiroNum = pilha.pop();
                        pilha.push(primeiroNum + segundoNum);
                    } else {
                        if (elementos[i].equals("-")) {
                            segundoNum = pilha.pop();
                            primeiroNum = pilha.pop();
                            pilha.push(primeiroNum - segundoNum);
                        } else {
                            if (elementos[i].equals("*")) {
                                segundoNum = pilha.pop();
                                primeiroNum = pilha.pop();
                                pilha.push(primeiroNum * segundoNum);
                            }
                        }
                    }
                }
            }

            i++;
        }

        System.out.println("Resultado: " + pilha.peek());
    }

}
