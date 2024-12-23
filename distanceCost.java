import java.text.DecimalFormat;
import java.util.Scanner;

public class distanceCost {
    public static void cost() {
        DecimalFormat df = new DecimalFormat("0.##");
        DecimalFormat df2 = new DecimalFormat("0");

        String[] menu = {
                "Nazwa trasy:",
                "Liczba kilometrów:",
                "Spalanie auta na 100km:",
                "Koszt litra paliwa:",
                "Ilość pasażerów:",
                "Liczba postojów:",
        };
        String[] typed = {
                "<Podaj nazwę trasy, np. Wieliczka - Berlin>",
                "<Podaj liczbę kilometrów do przejechania w dwie strony>",
                "<Podaj spalanie auta na 100km>",
                "<Podaj aktualny koszt za litr paliwa>",
                "<Podaj ilość osób która z Tobą jedzie>",
                "<Podaj ilość postojów (ręcznie), bądź skorzystaj z wyliczeń programu (automatycznie)>"
        };
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            for (int i = 0; i < menu.length; i++) {
                System.out.println((i + 1) + ". " + menu[i] + " " + typed[i]);
            }
            System.out.println("-------------------------------------------");
            System.out.println("7. PODSUMOWANIE");
            System.out.println("8. ZAPISZ");
            System.out.println("0. Powrót");
            System.out.println(">> WYBIERZ OPCJĘ KTÓRĄ CHCESZ WPROWADZIĆ <<");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1, 3, 4, 5:
                    System.out.println(menu[choice - 1]);
                    typed[choice - 1] = scanner.nextLine();
                    break;
                case 2:
                    System.out.println(menu[1]);
                    float kmCount = 0;
                    do {
                        try {
                            kmCount = Float.parseFloat(typed[1]);
                            if (kmCount < 0) {
                                System.out.println("Musisz podać liczbę powyżej zera!");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("To nie jest poprawna liczba!");
                        }
                    } while (kmCount < 0);
                    scanner.nextLine();
                    System.out.println("Liczba kilometrów podana w jedną stronę?: (tak/nie)");
                    double kmCountDouble = kmCount * 2;
                    String choiceKm = scanner.nextLine();
                    if (choiceKm.equalsIgnoreCase("tak")) {
                        typed[1] = String.valueOf(kmCountDouble);
                    } else if (choiceKm.equalsIgnoreCase("nie")) {
                        typed[1] = String.valueOf(kmCount);
                    }
                    break;
                case 6:
                    System.out.println(">> Wprowadzić dane: ręcznie/automatycznie ?");
                    String choiceStops = scanner.nextLine();
                    if (choiceStops.equalsIgnoreCase("ręcznie") || choiceStops.equalsIgnoreCase("recznie") || choiceStops.equalsIgnoreCase("R")) {
                        System.out.println(">> Wprowadź liczbę stopów: ");
                        typed[5] = scanner.nextLine();
                        break;
                    } else if (choiceStops.equalsIgnoreCase("automatycznie") || choiceStops.equalsIgnoreCase(("a"))) {
                        double km = Double.parseDouble(typed[1]);
                        double fuelConsumption = Double.parseDouble(typed[2]);
                        int reserve = 100;
                        double adjustedKm = km - reserve;

                        System.out.println(">> Podaj pojemność baku: ");
                        int fuelCapacity = scanner.nextInt();

                        double rangePerTank = (fuelCapacity / fuelConsumption) * 100;
                        int numberOfStops = (int) (adjustedKm / rangePerTank);

                        if (adjustedKm % rangePerTank != 0) {
                            numberOfStops++;
                        }
                        typed[5] = String.valueOf(numberOfStops);
                        break;
                    }
                case 7:
                    utilities.stars();
                    System.out.println();
                    System.out.println(">> PODSUMOWANIE TRASY <<");
                    System.out.println("Nazwa trasy: " + typed[0] + ",");
                    System.out.println("Auto przejedzie: " + typed[1] + "km,");
                    System.out.println("Spalanie auta: " + typed[2] + "L,");
                    try {
                        double distance = Double.parseDouble(typed[1]);
                        double fuelConsumption = Double.parseDouble(typed[2]);
                        double fuelCost = Double.parseDouble(typed[3]);
                        double passengers = Double.parseDouble(typed[4]);
                        double stops = Double.parseDouble(typed[5]);
                        double totalFuelNeed = (distance / 100) * fuelConsumption;
                        double tripCost = totalFuelNeed * fuelCost;
                        if (stops == 1) {
                            System.out.println("Na trasie z: 1 przystankiem");
                        } else {
                            System.out.println("Na trasię z: " + df2.format(stops) + " przystankami,");
                        }
                        System.out.println("Auto zużyje: " + df.format(totalFuelNeed) + "L paliwa,");
                        System.out.println("Całkowity koszt paliwa przy cenie: " + df.format(fuelCost) + "zł/L wyniesie: " + df.format(tripCost) + "zł,");
                        if (passengers == 1) {
                            System.out.println("Przy 1 pasażerze, koszt wyniesie: " + df.format(((tripCost / passengers) / (passengers + 1))) + "zł/os.");
                        } else {
                            System.out.println("Przy: " + df2.format(passengers) + " pasażerach, koszt wyniesie: " + df.format(tripCost / (passengers + 1)) + "zł/os.,");
                        }
                        utilities.stars();
                        System.out.println();
                    } catch (NumberFormatException e) {
                        System.out.println(">> Wystąpił błąd podczas kalkulacji, upewnij się że podałeś poprawne informacje!");
                    }
                case 0:
                    running = false;
                    utilities.stars();
                    System.out.println();
                    break;
                default:
                    System.out.println(">> Nieprawilowa opcja!");
            }
        }
    }
}
