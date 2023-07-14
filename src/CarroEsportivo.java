public class CarroEsportivo extends Carro {
    public CarroEsportivo(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public void acelerar() {
        System.out.println("Carro esportivo acelerando...");
    }

    @Override
    public void frear() {
        System.out.println("Carro esportivo freando...");
    }
}
