public class SedanCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Montando o Sedan");
    }

    @Override
    public void paint() {
        System.out.println("Pintando o Sedan");
    }
}
