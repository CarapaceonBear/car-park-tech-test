public class CarPark {

    private int motorcycleSpacesMax;
    private int motorcycleSpacesRemaining;
    private int parkingSpacesMax;
    private int parkingSpacesRemaining;
    private int parkedMotorcycles = 0;
    private int parkedCars = 0;
    private int parkedVans = 0;

    public CarPark(int motorcycleSpaces, int parkingSpaces) {
        this.motorcycleSpacesMax = motorcycleSpaces;
        this.motorcycleSpacesRemaining = motorcycleSpaces;
        this.parkingSpacesMax = parkingSpaces;
        this.parkingSpacesRemaining = parkingSpaces;
    }

    // populate car park

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
