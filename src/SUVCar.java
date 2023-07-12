public class SUVCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Montando o SUV");
    }

    @Override
    public void paint() {
        System.out.println("Pintando o SUV");
    }
}
