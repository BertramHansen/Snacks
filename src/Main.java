import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Automat automat = new Automat();
        Scanner scanner = new Scanner(System.in);

        int varePris;
        int betaltBeløb;

        System.out.println("Velkommen til! Hvad koster varen? ");
        varePris = scanner.nextInt();

        System.out.println("Vi tager desværre kun kontanter... Hvor meget vil du gerne betale? så skal jeg regne retur beløbetud! ");

        betaltBeløb = scanner.nextInt();

        try {
            // Beregn byttepenge
            int returBeløb = automat.pengeRetur(varePris, betaltBeløb);

            // Udskriv basisinformation
            System.out.println("Varepris: " + varePris + " kr");
            System.out.println("Betalt beløb: " + betaltBeløb + " kr");
            System.out.println("Byttepenge: " + returBeløb + " kr");

            // Brug byttepenge-metoden til at finde antallet af hver seddel/mønt
            int[] resultat = automat.byttepenge(returBeløb);

            // Udskriv antallet af hver seddel og mønt
            System.out.println("Antal 200 kr: " + resultat[0]);
            System.out.println("Antal 100 kr: " + resultat[1]);
            System.out.println("Antal 50 kr: " + resultat[2]);
            System.out.println("Antal 20 kr: " + resultat[3]);
            System.out.println("Antal 10 kr: " + resultat[4]);
            System.out.println("Antal 5 kr: " + resultat[5]);
            System.out.println("Antal 2 kr: " + resultat[6]);
            System.out.println("Antal 1 kr: " + resultat[7]);

        } catch (IllegalArgumentException e) {
            System.out.println("Fejl: " + e.getMessage());
        }
    }
}