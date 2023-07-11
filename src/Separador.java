import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Separador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> masculino = new ArrayList<>();
        List<String> feminino = new ArrayList<>();

        int totalPessoas;

        System.out.print("Digite o número total de pessoas: ");
        totalPessoas = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        for (int i = 0; i < totalPessoas; i++) {
            System.out.print("Digite o nome da pessoa: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o sexo (M/F) da pessoa: ");
            String sexo = scanner.nextLine();

            if (sexo.equalsIgnoreCase("M")) {
                masculino.add(nome);
            } else if (sexo.equalsIgnoreCase("F")) {
                feminino.add(nome);
            } else {
                System.out.println("Sexo inválido. Ignorando pessoa.");
            }
        }

        System.out.println("Pessoas no grupo masculino:");
        for (String nome : masculino) {
            System.out.println(nome);
        }

        System.out.println("Pessoas no grupo feminino:");
        for (String nome : feminino) {
            System.out.println(nome);
        }
    }
}
