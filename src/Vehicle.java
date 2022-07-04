public abstract class Vehicle {

    private final int id;
    private String type;
    private String model;
    private String registration;
    private float parkingFee;

    private static int idCounter = 0;

    public Vehicle(String type, String model, String registration) {
        this.id = idCounter;
        idCounter++;
        this.type = type;
        this.model = model;
        this.registration = registration;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistration() {
        return registration;
    }
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public float getParkingFee() {
        return parkingFee;
    }
    public void setParkingFee(float parkingFee) {
        this.parkingFee = parkingFee;
    }
}
