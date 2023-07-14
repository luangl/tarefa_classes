import java.util.ArrayList;
import java.util.List;

public class Garagem<T extends Carro> {
    private List<T> carros;

    public Garagem() {
        carros = new ArrayList<>();
    }

    public void adicionarCarro(T carro) {
        carros.add(carro);
    }

    public void removerCarro(T carro) {
        carros.remove(carro);
    }

    public void exibirCarros() {
        for (T carro : carros) {
            System.out.println(carro.toString());
        }
    }
    public List<T> getCarros() {
        return carros;
    }
}
