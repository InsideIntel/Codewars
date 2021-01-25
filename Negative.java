public class Negative {

  public static int makeNegative(final int x) {
       return String.valueOf(x).contains("-") ? x : Integer.parseInt("-" + x);
    }
  
}
