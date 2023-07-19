import java.lang.annotation.Annotation;
@Tabela(nome = "Tabela do Luan")
public class MinhaClasse {
    public static void main(String[] args) {
        Class<?> classe = MinhaClasse.class;

        if (classe.isAnnotationPresent(Tabela.class)) {
            Tabela tabela = classe.getAnnotation(Tabela.class);
            String nomeTabela = tabela.nome();
            System.out.println("Nome da tabela: " + nomeTabela);
        }
    }
}