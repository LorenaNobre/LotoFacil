package lotofacil;




import java.util.Random;
import java.util.Scanner;

public class home {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int opcao;
        do {
            System.out.println("**************************");
            System.out.println("Menu LOTOFÁCIL:");
            System.out.println("1) Apostar de 0 a 100");
            System.out.println("2) Apostar de A à Z");
            System.out.println("3) Apostar em par ou ímpar");
            System.out.println("0) Sair");
            System.out.println("**************************");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Regras para a aposta de 0 a 100
                    int numeroApostado;
                    System.out.print("Digite um número de 0 a 100: ");
                    numeroApostado = scanner.nextInt();

                    if (numeroApostado < 0 || numeroApostado > 100) {
                        System.out.println("Aposta inválida.");
                    } else {
                        int numeroSorteado = random.nextInt(101);

                        if (numeroApostado == numeroSorteado) {
                            System.out.println("Você ganhou R$ 1.000,00 reais.");
                        } else {
                            System.out.println("Que pena! O número sorteado foi: " + numeroSorteado);
                        }
                    }
                    break;

                case 2:
                    // Regras para a aposta de A à Z
                    System.out.print("Digite uma letra de A à Z: ");
                    String input = scanner.next();
                    char letraApostada = input.toUpperCase() .charAt(0);
                    char letraPremiada = 'J'; // Substitua pela sua letra premiada

                    if (Character.isLetter(letraApostada)) {
                        if (letraApostada == letraPremiada) {
                            System.out.println("Você ganhou R$ 500,00 reais.");
                        } else {
                            System.out.println("Que pena! A letra sorteada foi: " + letraPremiada);
                        }
                    } else {
                        System.out.println("Aposta inválida.");
                    }
                    scanner.nextLine(); // Limpar o buffer de entrada
                    break;

                case 3:
                    // Regras para a aposta de número par ou ímpar
                    System.out.print("Digite um número inteiro: ");
                    int numeroParaApostar = scanner.nextInt();

                    if (numeroParaApostar % 2 == 0) {
                        System.out.println("Você ganhou R$ 100,00 reais.");
                    } else {
                        System.out.println("Que pena! O número digitado é ímpar e a premiação foi para números pares.");
                    }
                    break;

                case 0:
                    System.out.println("Saindo do programa.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}

