public class Car extends Vehicle {

    public Car(String model, String registration) {
        super("car", model, registration);
        super.setParkingFee(5.00f);
    }
}
