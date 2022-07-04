public class Main {
    public static void main(String[] args) {
        CarPark carPark = new CarPark(50, 200);
        carPark.populateCarPark(20);

        UserInput input = new UserInput("input");
        Commands commands = new Commands(input, carPark);

        commands.runCommands();
    }
}