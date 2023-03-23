
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

            // precisei deixar uma declaração de pilha fora dos Ifs, senão o autopreencher não reconhecia quando eu digito pilha
             Pilha<Double> pilha = new PilhaVetor<>();
          //  if (tipo == 'e' || tipo == 'E') {
            //             
           // } else {
               // if (tipo == 'd' || tipo == 'D') {
                //  Pilha<Double> pilha = new PilhaLista<>();    
              //  }
          //  }
                int i = 0;
                String str = "";
                Double primeiroNum = 0.0;
                Double segundoNum = 0.0;
                while(i < expressao.length()) {
                    if(expressao.charAt(i) == ' ') {

                    } else{
                    if( Character.isDigit(expressao.charAt(i))) {
                        str = String.valueOf(expressao.charAt(i));
                      pilha.push(Double.valueOf(str));
                    } else {
                        if(expressao.charAt(i) == '/') {
                        segundoNum = pilha.pop();
                        primeiroNum = pilha.pop();
                        pilha.push(primeiroNum / segundoNum);
                        } else {
                            if(expressao.charAt(i) == '+') {
                                segundoNum = pilha.pop();
                                primeiroNum = pilha.pop();  
                                pilha.push(primeiroNum + segundoNum);
                            } else {
                                if(expressao.charAt(i) == '-') {
                                    segundoNum = pilha.pop();
                                    primeiroNum = pilha.pop();  
                                    pilha.push(primeiroNum - segundoNum);
                                } else {
                                    if(expressao.charAt(i) == '*') {
                                        segundoNum = pilha.pop();
                                        primeiroNum = pilha.pop();  
                                        pilha.push(primeiroNum * segundoNum);
                                    }
                                }
                            }
                        }
     
                        
                    }
                }
                     
                    
                    i++;
                }

            System.out.println("Resultado: " + pilha.peek());
            teclado.close();
        }


    }
