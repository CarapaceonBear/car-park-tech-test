public class Van extends Vehicle {

    public Van(String model, String registration) {
        super("van", model, registration);
        super.setParkingFee(8.00f);
    }
}
