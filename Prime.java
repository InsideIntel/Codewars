public class Prime {
  public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        int top = (int) Math.sqrt(num);
        for (int i = 2; i <= top; i++) {
            if (num %i == 0) {
                return false;
            }
        }
        return true;
    }
