import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutomatTest {

    @Test
    void testPengeRetur_PositiveCase() {
        Automat automat = new Automat();
        int retur = automat.pengeRetur(20, 50);
        assertEquals(30, retur, "Byttepengene burde være 30, når varen koster 20 og der betales 50.");
        System.out.println("Test 1 - Positive case: Passerede, byttepengene var som forventet (30 kr).");
    }

    @Test
    void testPengeRetur_InsufficientPayment() {
        Automat automat = new Automat();
        try {
            automat.pengeRetur(50, 20);
            fail("Forventet en IllegalArgumentException, når det betalte beløb er for lavt.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 2 - Insufficient payment: Passerede, IllegalArgumentException blev kastet som forventet.");
        }
    }

    @Test
    void testPengeRetur_NegativeVarePris() {
        Automat automat = new Automat();
        try {
            automat.pengeRetur(-10, 50);
            fail("Forventet en IllegalArgumentException, når vareprisen er negativ.");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3 - Negative varepris: Passerede, IllegalArgumentException blev kastet som forventet.");
        }
    }

    @Test
    void testPengeRetur_NegativeBetaltBeløb() {
        Automat automat = new Automat();
        try {
            automat.pengeRetur(20, -50);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    void testByttepenge_87kr() {
        Automat automat = new Automat();
        int beløb = 87;  // Eksempelbeløb for byttepenge
        int[] forventetResultat = {4, 0, 1, 1, 0};  // 4x20 kr, 0x10 kr, 1x5 kr, 1x2 kr, 0x1 kr

        int[] resultat = automat.byttepenge(beløb);

        assertArrayEquals(forventetResultat, resultat, "Byttepenge for 87 kr skulle være [4, 0, 1, 1, 0].");
    }

    @Test
    void testByttepenge_50kr() {
        Automat automat = new Automat();
        int beløb = 50;
        int[] forventetResultat = {2, 1, 0, 0, 0};  // 2x20 kr, 1x10 kr, 0x5 kr, 0x2 kr, 0x1 kr

        int[] resultat = automat.byttepenge(beløb);
        assertArrayEquals(forventetResultat, resultat, "Byttepenge for 50 kr skulle være [2, 1, 0, 0, 0].");
    }

    @Test
    void testByttepenge_3kr() {
        Automat automat = new Automat();
        int beløb = 3;
        int[] forventetResultat = {0, 0, 0, 1, 1};  // 0x20 kr, 0x10 kr, 0x5 kr, 1x2 kr, 1x1 kr

        int[] resultat = automat.byttepenge(beløb);

        assertArrayEquals(forventetResultat, resultat, "Byttepenge for 3 kr skulle være [0, 0, 0, 1, 1].");
    }

    @Test
    void testByttepenge_0kr() {
        Automat automat = new Automat();
        int beløb = 0;
        int[] forventetResultat = {0, 0, 0, 0, 0};  // Ingen mønter kræves

        int[] resultat = automat.byttepenge(beløb);

        assertArrayEquals(forventetResultat, resultat, "Byttepenge for 0 kr skulle være [0, 0, 0, 0, 0].");
    }
}



