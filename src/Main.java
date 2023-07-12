public class Main {
    public static void main(String[] args) {
        CarFactory sedanFactory = new SedanCarFactory();
        Car sedan = sedanFactory.createCar();
        sedan.assemble();
        sedan.paint();

        CarFactory suvFactory = new SUVCarFactory();
        Car suv = suvFactory.createCar();
        suv.assemble();
        suv.paint();
    }
}

