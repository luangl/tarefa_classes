public class Main {
    public static void main(String[] args) {
        Garagem<Carro> garagem = new Garagem<>();

        CarroEsportivo esportivo = new CarroEsportivo("Ferrari", "F40", 1990);
        CarroSedan sedan = new CarroSedan("Honda", "Civic", 2022);

        garagem.adicionarCarro(esportivo);
        garagem.adicionarCarro(sedan);

        garagem.exibirCarros();

        System.out.println();

        // Exemplo de chamada de métodos específicos de cada tipo de carro
        for (Carro carro : garagem.getCarros()) {
            carro.acelerar();
            carro.frear();
            System.out.println();
        }
    }
}
