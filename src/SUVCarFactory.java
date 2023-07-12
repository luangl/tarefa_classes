public class SUVCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new SUVCar();
    }
}
