import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = lerListaPessoasDoConsole();

        System.out.println("Tabela completa:");
        imprimirTabela(pessoas);

        List<Pessoa> mulheres = filtrarMulheres(pessoas);

        System.out.println("\nTabela de Mulheres:");
        imprimirTabela(mulheres);
    }

    private static List<Pessoa> lerListaPessoasDoConsole() {
        List<Pessoa> pessoas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite as pessoas (nome,genero), uma por linha (ou 'fim' para terminar):");
        String linha;
        while (!(linha = scanner.nextLine()).equalsIgnoreCase("fim")) {
            String[] partes = linha.split(",");
            if (partes.length == 2) {
                String nome = partes[0].trim();
                String genero = partes[1].trim().toLowerCase();

                if (genero.equals("masculino") || genero.equals("feminino")) {
                    pessoas.add(new Pessoa(nome, genero));
                } else {
                    System.out.println("Gênero inválido. Use 'Masculino' ou 'Feminino'.");
                }
            } else {
                System.out.println("Entrada inválida. Use o formato 'nome,genero'.");
            }
        }

        return pessoas;
    }

    private static List<Pessoa> filtrarMulheres(List<Pessoa> pessoas) {
        return pessoas.stream()
                .filter(pessoa -> pessoa.getGenero().equals("feminino"))
                .collect(Collectors.toList());
    }

    private static void imprimirTabela(List<Pessoa> pessoas) {
        System.out.println("-------------");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
        }
        System.out.println("-------------");
    }
}
