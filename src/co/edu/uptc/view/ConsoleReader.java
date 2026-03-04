package co.edu.uptc.view;

import java.util.Scanner;

public class ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);

    public String readLine(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Error: Este campo no puede estar vacío.");
            }
        } while (input.isEmpty());
        return input;
    }

    public double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value <= 0) {
                    System.out.println("Error: El precio debe ser mayor a 0.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
    }

    public Integer readInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }
}