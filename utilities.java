public class utilities {
    public static void stars () {
    for (int i = 0; i <= 80; i++) {
        System.out.print("*");
        }
    }
    public static void appName () {
        String text = ">> PLANER WYCIECZKI << ver 0.1";
        for (int i = 0; i <= 0;  i++) {
            System.out.println();
            System.out.print("*");
        }
            for (int j = 0; j <= 22; j++) {
                System.out.print(" ");
            }
            System.out.print(text);
            for (int k = 0; k <= 55 - text.length(); k++) {
                System.out.print(" ");
            }
            System.out.println("*");
        for (int i = 0; i <= 80; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
