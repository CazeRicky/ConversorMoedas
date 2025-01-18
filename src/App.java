import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConversorDeMoedas conversor = new ConversorDeMoedas();

        System.out.println("Bem-vindo ao Conversor de Moedas!");
        System.out.println("Escolha uma das opções de conversão:");
        System.out.println("1. USD para BRL");
        System.out.println("2. EUR para BRL");
        System.out.println("3. GBP para BRL");
        System.out.println("4. JPY para BRL");
        System.out.println("5. BRL para USD");
        System.out.println("6. AUD para BRL");
        System.out.println("7. CAD para BRL");
        System.out.println("8. CHF para BRL");
        System.out.println("9. CNY para BRL");
        System.out.println("10. BRL para EUR");

        System.out.print("Digite o número da conversão desejada: ");
        int escolha = scanner.nextInt();

        System.out.print("Digite o valor que deseja converter: ");
        double valor = scanner.nextDouble();

        double resultado = conversor.converter(escolha, valor);
        if (resultado != -1) {
            System.out.printf("Valor convertido: %.2f%n", resultado);
        } else {
            System.out.println("Opção inválida.");
        }

        scanner.close();
    }
}
