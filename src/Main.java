import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {

            System.out.println("==== Conversor de Moedas ====");
            System.out.println("1 - USD para BRL");
            System.out.println("2 - BRL para USD");
            System.out.println("3 - USD para EUR");
            System.out.println("4 - EUR para USD");
            System.out.println("5 - USD para ARS");
            System.out.println("6 - ARS para USD");
            System.out.println("7 - Sair");

            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            if (opcao == 7) {
                System.out.println("Encerrando...");
                break;
            }

            System.out.print("Digite o valor: ");
            double valor = scanner.nextDouble();

            // Aqui vamos chamar a conversão, depois que criar o conversor
            ConversorMoeda conversor = new ConversorMoeda();
            double resultado = conversor.converter(opcao, valor);

            System.out.printf("Resultado: %.2f%n", resultado);
            System.out.println();
        }

        scanner.close();
    }
}