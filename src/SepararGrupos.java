import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SepararGrupos {

    public static void main(String[] args) {
        Map<String, List<String>> gruposPorGenero = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite os nomes e sexos das pessoas separados por vírgula (Nome1 - (M/F), Nome2 - (M/F), ...): ");
        String entrada = scanner.nextLine();

        String[] pessoas = entrada.split(",");
        for (String pessoa : pessoas) {
            String[] partes = pessoa.trim().split("-");
            if (partes.length != 2) {
                System.out.println("Entrada inválida para a pessoa: " + pessoa.trim());
                continue;
            }

            String nome = partes[0].trim();
            String sexo = partes[1].trim();

            if (sexo.equalsIgnoreCase("M")) {
                adicionarPessoaAoGrupo(nome, sexo, "Masculino", gruposPorGenero);
            } else if (sexo.equalsIgnoreCase("F")) {
                adicionarPessoaAoGrupo(nome, sexo, "Feminino", gruposPorGenero);
            } else {
                System.out.println("Sexo inválido para a pessoa: " + pessoa.trim());
            }
        }

        System.out.println("Grupos separados por gênero:");
        for (Map.Entry<String, List<String>> entry : gruposPorGenero.entrySet()) {
            String genero = entry.getKey();
            List<String> pessoasDoGenero = entry.getValue();

            System.out.println(genero + ":");
            for (String pessoa : pessoasDoGenero) {
                System.out.println("- " + pessoa);
            }
            System.out.println();
        }
    }

    private static void adicionarPessoaAoGrupo(String nome, String sexo, String genero, Map<String, List<String>> gruposPorGenero) {
        if (!gruposPorGenero.containsKey(genero)) {
            gruposPorGenero.put(genero, new ArrayList<>());
        }

        List<String> pessoas = gruposPorGenero.get(genero);
        pessoas.add(nome + " - " + sexo);
    }
}
