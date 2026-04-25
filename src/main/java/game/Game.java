package game;

import java.util.Scanner;

public class Game {
    private final City city;
    private boolean running;

    public Game(City city) {
        this.city = city;
        this.running = true;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (running) {
            printMenu();
            String input = scanner.nextLine();

            handleCommand(input, scanner);
        }
    }

    private void handleCommand(String input, Scanner scanner) {
        switch (input.toLowerCase()) {
            case "place" -> handlePlace(scanner);
            case "remove" -> handleRemove(scanner);
            case "next" -> city.tick();
            case "quit" -> running = false;
            default -> System.out.println("Invalid command.");
        }
    }

    private void handlePlace(Scanner scanner) {
        BuildingFactory buildingFactory = new BuildingFactory();

        System.out.println("Choose building type:");
        System.out.println("1 - Cottage");
        System.out.println("2 - House");
        System.out.println("3 - Mansion");
        System.out.println("4 - Farm");
        System.out.println("5 - Factory");
        System.out.println("6 - Apartment Complex");
        System.out.println("7 - Cancel");

        String choice = scanner.nextLine();

        Building building = switch (choice) {
            case "1" -> buildingFactory.createCottage("Cottage");
            case "2" -> buildingFactory.createHouse("House");
            case "3" -> buildingFactory.createMansion("Mansion");
            case "4" -> buildingFactory.createFarm("Farm");
            case "5" -> buildingFactory.createFactory("Factory");
            case "6" -> buildingFactory.createApartmentComplex("Apartments");
            default -> null;
        };

        if (building == null) {
            System.out.println("Cancelled.");
            return;
        }

        System.out.println("Enter x:");
        int x = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter y:");
        int y = Integer.parseInt(scanner.nextLine());

        boolean success = city.place(building, new Position(x, y));
        System.out.println(success ? "Placed." : "Could not place building.");
    }

    private void handleRemove(Scanner scanner) {
        System.out.println("Enter x:");
        int x = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter y:");
        int y = Integer.parseInt(scanner.nextLine());

        boolean success = city.demolish(new Position(x, y));
        System.out.println(success ? "Removed." : "Nothing to remove.");
    }

    private void printMenu() {
        System.out.println("\nChoose an action:");
        System.out.println("place - Place a building");
        System.out.println("remove - Remove a building");
        System.out.println("next - Advance to next day");
        System.out.println("quit - Exit game");
    }
}