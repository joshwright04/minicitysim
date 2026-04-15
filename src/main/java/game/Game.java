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
        System.out.println("Enter x:");
        int x = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter y:");
        int y = Integer.parseInt(scanner.nextLine());

        boolean success = city.place(new House("Cottage"), new Position(x, y));
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