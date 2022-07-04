import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class Commands {

    private String[] commandList = {"park vehicle", "check remaining spaces", "check numbers parked",
            "list parked vehicles", "get daily intake", "check out vehicle"};
    private final UserInput input;
    private final CarPark carPark;
    DecimalFormat df = new DecimalFormat("0.00");

    public Commands(UserInput input, CarPark carPark){
        this.input = input;
        this.carPark = carPark;
    }

    public void runCommands() {
        boolean isActive = true;

        while (isActive) {
            printCommands();
            int response = input.getIntegerInput(commandList.length + 1);

            switch (response) {
                case 1:
                    String vehicleType = input.getStringInput("type of vehicle");
                    String vehicleModel = input.getStringInput("vehicle model");
                    String vehicleRegistration = input.getStringInput("registration number");
                    carPark.parkVehicle(vehicleType, vehicleModel, vehicleRegistration);
                    break;
                case 2:
                    input.printMessage(carPark.checkRemainingSpaces());
                    break;
                case 3:
                    input.printMessage(carPark.checkParkedVehicles());
                    break;
                case 4:
                    List<Vehicle> parkedVehicles = carPark.getParkedVehicles();
                    for (Vehicle vehicle : parkedVehicles) {
                        input.printMessage(String.format("%s, #%d, %s, %s", vehicle.getType(), vehicle.getId(), vehicle.getModel(), vehicle.getRegistration()));
                    }
                    break;
                case 5:
                    input.printMessage(String.format("Daily intake: £%s", df.format(carPark.getDailyIntake())));
                    break;
                case 6:
                    String searchingRegistration = input.getStringInput("registration number");
                    Vehicle foundVehicle = carPark.searchVehicleByRegistration(searchingRegistration);
                    carPark.getParkedVehicles().remove(foundVehicle);
                    break;
                default:
                    isActive = false;
            }
        }
    }

    public void printCommands() {
        for (int i = 0; i < commandList.length; i++) {
            input.printMessage(String.format("%d - %s", (i + 1), commandList[i]));
        }
        input.printMessage(String.format("%d - Exit program", commandList.length + 1));
    }

    public String[] getCommandList() {
        return commandList;
    }
}
