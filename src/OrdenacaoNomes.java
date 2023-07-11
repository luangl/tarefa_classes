import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class OrdenacaoNomes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite os nomes das pessoas separados por vírgula: ");
        String entrada = scanner.nextLine();

        // Separar os nomes usando a vírgula como delimitador
        String[] nomes = entrada.split(",");

        List<String> listaNomes = new ArrayList<>();

        // Adicionar os nomes à lista
        for (String nome : nomes) {
            listaNomes.add(nome.trim()); // Remove espaços em branco extras
        }

        // Ordenar os nomes em ordem alfabética
        Collections.sort(listaNomes);

        // Imprimir os nomes ordenados
        System.out.println("Nomes em ordem alfabética:");
        for (String nome : listaNomes) {
            System.out.println(nome);
        }
    }
}
