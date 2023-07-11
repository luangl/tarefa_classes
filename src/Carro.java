/**
 * @author Luan Glaab
 */
// Classe Carro
public class Carro {
    // Propriedades da classe
    private String marca;
    private String modelo;
    private int ano;
    private int velocidade;

    /**
     * Construtor da classe Carro
     * @param marca a marca do carro
     * @param modelo o modelo do carro
     * @param ano o ano de fabricação do carro
     */
    public Carro(String marca, String modelo, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.velocidade = 0; // Inicialmente o carro está parado
    }

    /**
     * Método para acelerar o carro
     * @param incremento o valor do incremento de velocidade
     */
    public void acelerar(int incremento) {
        velocidade += incremento;
    }

    /**
     * Método para frear o carro
     * @param decremento o valor do decremento de velocidade
     */
    public void frear(int decremento) {
        if (velocidade >= decremento) {
            velocidade -= decremento;
        } else {
            velocidade = 0;
        }
    }

    /**
     * Método para obter a velocidade atual do carro
     * @return a velocidade atual do carro
     */
    public int getVelocidade() {
        return velocidade;
    }

    /**
     * Método para exibir informações do carro
     */
    public void exibirInformacoes() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Velocidade: " + velocidade + " km/h");
    }

    /**
     * Método principal (main) para teste da classe
     * @param args argumentos de linha de comando
     */
    public static void main(String[] args) {
        // Criando um objeto da classe Carro
        Carro meuCarro = new Carro("Toyota", "Corolla", 2020);

        // Acelerando o carro duas vezes
        meuCarro.acelerar(20);
        meuCarro.acelerar(30);

        // Exibindo informações do carro
        meuCarro.exibirInformacoes();

        // Freando o carro
        meuCarro.frear(15);

        // Exibindo informações do carro novamente
        meuCarro.exibirInformacoes();
    }
}

