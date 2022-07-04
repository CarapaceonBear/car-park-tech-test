import java.lang.module.ModuleReader;
import java.util.ArrayList;
import java.util.List;

public class CarPark {

    private int motorcycleSpacesMax;
    private int motorcycleSpacesRemaining;
    private int parkingSpacesMax;
    private int parkingSpacesRemaining;
    private int parkedMotorcycles = 0;
    private int parkedCars = 0;
    private int parkedVans = 0;
    private List<Vehicle> parkedVehicles = new ArrayList<>();

    public CarPark(int motorcycleSpaces, int parkingSpaces) {
        this.motorcycleSpacesMax = motorcycleSpaces;
        this.motorcycleSpacesRemaining = motorcycleSpaces;
        this.parkingSpacesMax = parkingSpaces;
        this.parkingSpacesRemaining = parkingSpaces;
    }

    // populate car park
    String[] motorcycles = {"yamaha", "honda", "ducati", "kawasaki", "harley-davidson", "bmw"};
    String[] cars = {"bmw", "porsche", "ford", "hyundai", "honda", "volkswagen"};
    String[] vans = {"chevrolet", "citroen", "dacia", "fiat", "ford", "honda"};

    public void populateCarPark(int numberOfVehicles) {
        String[][] availableVehicles = new String[3][6];
        availableVehicles[0] = motorcycles;
        availableVehicles[1] = cars;
        availableVehicles[2] = vans;
        String[] alphabet = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v",
                "w","x","y","z"};

        for (int i = 0; i < numberOfVehicles; i++) {
            int whichVehicle = (int) (Math.random() * 3);
            int whichModel = (int) (Math.random() * 6);
            StringBuilder registration = new StringBuilder();
            for (int j = 0; j < 7; j++) {
                if (j == 2 || j == 3) {
                    int character = (int) (Math.random() * 10);
                    registration.append(character);
                } else {
                    String character = alphabet[(int) (Math.random() * 26)];
                    registration.append(character);
                }
            }
            switch (whichVehicle) {
                case 0:
                    parkedVehicles.add(new Motorcycle(availableVehicles[0][whichModel], registration.toString()));
                    break;
                case 1:
                    parkedVehicles.add(new Car(availableVehicles[1][whichModel], registration.toString()));
                    break;
                case 2:
                    parkedVehicles.add(new Van(availableVehicles[2][whichModel], registration.toString()));
                    break;
            }
        }

    }

    public void listParkedVehicles() {
        for (Vehicle vehicle : parkedVehicles) {
            System.out.println(vehicle.getType() + vehicle.getModel() + vehicle.getRegistration());
        }
    }


    // park vehicle

    // check remaining spaces

    // check number of each vehicle parked

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
}
