public class Automat {
    private int varepris;
    private int betaltBeløb;
    private int[] værdier;
    private int[] antalVærdier;

    public int pengeRetur(int varePris, int betaltBeløb) throws IllegalArgumentException {
        if (varePris < 0 || betaltBeløb < 0) {
            throw new IllegalArgumentException("Varepris og betalings beløb skal være over 0 kr.");
        }
        if (betaltBeløb < varePris) {
            throw new IllegalArgumentException("Det indtatede betalingsbeløb er ikke tilstrækkeligt");
        }
        int returbeløb = betaltBeløb - varePris;
        return returbeløb;
    }


    public int[] byttepenge(int beløb) {
        værdier = new int[]{200, 100, 50, 20, 10, 5, 2, 1};
        antalVærdier = new int[værdier.length];

        for (int i = 0; i < værdier.length; i++) {

            antalVærdier[i] = beløb / værdier[i];

            beløb %= værdier[i];
        }
        return antalVærdier;
    }


    @Override
    public String toString(){
      for (int i = 0; i <værdier.length; i++){
          return "Antal af " + værdier[i] + "kr. = " + antalVærdier[i];
      }
      return null;
    }

}
