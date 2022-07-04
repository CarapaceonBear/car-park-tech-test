public class Motorcycle extends Vehicle {

    public Motorcycle(String model, String registration) {
        super("motorcycle", model, registration);
        super.setParkingFee(3.50f);
    }
}
