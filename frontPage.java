import java.util.Scanner;

public class frontPage {
    static Scanner scanner = new Scanner(System.in);

    public static void stars() {
        for (int i = 0; i <= 80; i++) {
            System.out.print("*");
        }
    }

    public static void appName() {
        String text = ">> PLANER WYCIECZKI << ver 0.1";
        System.out.println();
        for (int j = 0; j < 1; j++) {
            System.out.print("*");
        }
        for (int k = 0; k < 22; k++) {
            System.out.print(" ");
        }
        System.out.print(text);
        for (int l = 0; l < 27; l++) {
            System.out.print(" ");
        }
        System.out.print("*");
        System.out.println();
    }

    public static void options() {
        System.out.println();
        String[] options = {
            ">> Oblicz trasę.",
            ">> Oblicz wydatki.",
            ">> Lista do zwiedzenia.",
            ">> Podsumowanie.",
            ">> Zapisane.",
            ">> Wyjście."
    };
    boolean exit = false;
    int choice;


    while (!exit) {
    for (int i = 0; i < options.length; i++) {
        System.out.println((i + 1) + ". " + options[i]);
    }
    frontPage.stars();
    System.out.println();
    choice = scanner.nextInt();
    if (choice < 1 || choice > options.length) {
        System.out.println("Nieprawidłowy wybór, wybierz ponownie.");
        continue;
        }
    switch (choice) {
        case 1: // OBLICZ TRASE
            distanceCost.cost();
            break;
        case 2: // OBLICZ WYDATKI
            travelCost.cost();
            break;
        case 3: // Lista do zwiedzania
            toSee.see();
            break;
        case 4: // Podsumowanie
            System.out.println("Podsumowanie.");
            break;
        case 5: // ZAPISANE
            System.out.println("ZAPISANE.");
            break;
        case 6: // WYJSCIE
            exit = true;
            System.out.println("Do zobaczenia! :)");
            break;
        default:
            System.out.println("Nieprawidłowy wybór.");
            }
        }
        scanner.close();
    }
}
