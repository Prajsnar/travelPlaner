import java.text.DecimalFormat;
import java.util.Scanner;

public class travelCost {
    public static void cost () {
        DecimalFormat df = new DecimalFormat("0.#");

        String[] menu = {
                "Nazwa wydatku:",
                "Koszt:",
                "Waluta:",
                "Informacje:"
        };
        String[] typed = {
                "Brak informacji",
                "Brak informacji",
                "Brak informacji",
                "Brak informacji",
        };
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i] + " " + typed[i]);
            }
            System.out.println("-------------------------------------------");
            System.out.println("5. ZAPISZ");
            System.out.println("0. Powrót");
            System.out.println(">> WYBIERZ OPCJĘ KTÓRĄ CHCESZ WPROWADZIĆ <<");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1,4:
                    System.out.println(menu[choice - 1]);
                    typed[choice - 1] = scanner.nextLine();
                    break;
                case 2:
                    System.out.println(">> Podaj walutę: ");
                    String currency = scanner.nextLine();
                    System.out.println(">> Podaj kwotę: ");
                    double cost = scanner.nextDouble();
                    String zloty = "złoty";
                    String euro = "euro";
                    double euroCost = 4.26;
                    if (currency.equalsIgnoreCase("euro")) {
                        typed[2] = euro;
                        typed[1] = String.valueOf(df.format(cost*euroCost));
                    } else {
                            typed[2] = zloty;
                            typed[1] = String.valueOf(df.format(cost));
                        }
                    break;
                case 3:
                    System.out.println(">> Aby wprowadzić walutę, skorzystaj z opcji wprowadzenia kosztu.");
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Zapis wkrótce");
                case 0:
                    running = false;
                    utilities.stars();
                    System.out.println();
                    break;
                default:
                    System.out.println(">> Nieprawiłowa opcja!");
            }
        }
    }
}
