import java.util.ArrayList;
import java.util.List;

public class CarPark {

    private final int motorcycleSpacesMax;
    private int motorcycleSpacesRemaining;
    private final int parkingSpacesMax;
    private int parkingSpacesRemaining;
    private int parkedMotorcycles = 0;
    private int parkedCars = 0;
    private int parkedVans = 0;
    private final List<Vehicle> parkedVehicles = new ArrayList<>();
    private float dailyIntake = 0;

    public CarPark(int motorcycleSpaces, int parkingSpaces) {
        this.motorcycleSpacesMax = motorcycleSpaces;
        this.motorcycleSpacesRemaining = motorcycleSpaces;
        this.parkingSpacesMax = parkingSpaces;
        this.parkingSpacesRemaining = parkingSpaces;
    }

    String[] motorcycles = {"yamaha", "honda", "ducati", "kawasaki", "harley-davidson", "bmw"};
    String[] cars = {"bmw", "porsche", "ford", "hyundai", "honda", "volkswagen"};
    String[] vans = {"chevrolet", "citroen", "dacia", "fiat", "ford", "honda"};

    public void populateCarPark(int numberOfVehicles) {
        String[][] availableVehicles = new String[3][6];
        availableVehicles[0] = motorcycles;
        availableVehicles[1] = cars;
        availableVehicles[2] = vans;
        String[] vehicleTypes = {"motorcycle", "car", "van"};
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v",
                "w","x","y","z"};
        for (int i = 0; i < numberOfVehicles; i++) {
            int whichVehicle = (int) (Math.random() * 3);
            int whichModel = (int) (Math.random() * 6);
            StringBuilder registration = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                if (j == 2 || j == 3) {
                    int character = (int) (Math.random() * 10);
                    registration.append(character);
                } else if (j == 4) {
                    registration.append(" ");
                } else {
                    String character = alphabet[(int) (Math.random() * 26)];
                    registration.append(character);
                }
            }
            parkVehicle(vehicleTypes[whichVehicle], availableVehicles[whichVehicle][whichModel], registration.toString());
        }

    }

    public void listParkedVehicles() {
        for (Vehicle vehicle : parkedVehicles) {
            System.out.println(String.format("%s, #%d, %s, %s", vehicle.getType(), vehicle.getId(), vehicle.getModel(), vehicle.getRegistration()));
        }
    }


    // park vehicle
    public void parkVehicle(String type, String model, String registration) {
        switch (type) {
            case "motorcycle":
                if (motorcycleSpacesRemaining > 0) {
                    motorcycleSpacesRemaining --;
                } else if (parkingSpacesRemaining > 0) {
                    parkingSpacesRemaining --;
                } else {
                    return;
                }
                Motorcycle newMotorcycle = new Motorcycle(model, registration);
                parkedVehicles.add(newMotorcycle);
                parkedMotorcycles ++;
                dailyIntake += newMotorcycle.getParkingFee();
                break;
            case "car":
                if (parkingSpacesRemaining > 0) {
                    parkingSpacesRemaining --;
                } else {
                    return;
                }
                Car newCar = new Car(model, registration);
                parkedVehicles.add(newCar);
                parkedCars++;
                dailyIntake += newCar.getParkingFee();
                break;
            case "van":
                if (parkingSpacesRemaining > 2) {
                    parkingSpacesRemaining -= 3;
                } else {
                    return;
                }
                Van newVan = new Van(model, registration);
                parkedVehicles.add(newVan);
                parkedVans++;
                dailyIntake += newVan.getParkingFee();
                break;
        }
    }

    public String checkRemainingSpaces() {
        return (String.format("%d motorcycle spaces remaining, %d regular spaces remaining",
                motorcycleSpacesRemaining, parkingSpacesRemaining));
    }

    public String checkParkedVehicles() {
        return (String.format("%d motorcycles parked, %d cars parked, %d vans parked",
                parkedMotorcycles, parkedCars, parkedVans));
    }

    public int getMotorcycleSpacesMax() {
        return motorcycleSpacesMax;
    }

    public int getMotorcycleSpacesRemaining() {
        return motorcycleSpacesRemaining;
    }

    public int getParkingSpacesMax() {
        return parkingSpacesMax;
    }

    public int getParkingSpacesRemaining() {
        return parkingSpacesRemaining;
    }

    public int getParkedMotorcycles() {
        return parkedMotorcycles;
    }
    public void setParkedMotorcycles(int parkedMotorcycles) {
        this.parkedMotorcycles = parkedMotorcycles;
    }

    public int getParkedCars() {
        return parkedCars;
    }
    public void setParkedCars(int parkedCars) {
        this.parkedCars = parkedCars;
    }

    public int getParkedVans() {
        return parkedVans;
    }
    public void setParkedVans(int parkedVans) {
        this.parkedVans = parkedVans;
    }

    public List<Vehicle> getParkedVehicles() {
        return parkedVehicles;
    }

    public float getDailyIntake() {
        return dailyIntake;
    }
}
