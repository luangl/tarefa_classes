import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {

    private List<Pessoa> mulheres;

    @Before
    public void setup() {
        List<Pessoa> pessoas = List.of(
                new Pessoa("Maria", "Feminino"),
                new Pessoa("João", "Masculino"),
                new Pessoa("Ana", "FEMININO"),
                new Pessoa("Pedro", "Masculino"),
                new Pessoa("Lucia", "feminino"),
                new Pessoa("Carlos", "M")
        );

        mulheres = filtrarMulheres(pessoas);
    }

    @Test
    public void testApenasMulheresNaLista() {
        mulheres.forEach(pessoa -> assertEquals("feminino", pessoa.getGenero().toLowerCase()));
    }

    @Test
    public void testTodasPessoasNaLista() {
        assertEquals(3, mulheres.size());
    }

    private List<Pessoa> filtrarMulheres(List<Pessoa> pessoas) {
        return pessoas.stream()
                .filter(pessoa -> pessoa.getGenero().equalsIgnoreCase("Feminino"))
                .collect(Collectors.toList());
    }
}
