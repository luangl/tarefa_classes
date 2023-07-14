public class CarroSedan extends Carro {
    public CarroSedan(String marca, String modelo, int ano) {
        super(marca, modelo, ano);
    }

    @Override
    public void acelerar() {
        System.out.println("Carro sedan acelerando...");
    }

    @Override
    public void frear() {
        System.out.println("Carro sedan freando...");
    }
}
