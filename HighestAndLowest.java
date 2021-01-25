import java.util.Arrays;

public class HighestAndLowest {
  public static String highAndLow(String numbers) {
        // Code here or
        String[] arr = numbers.split(" ");
        int [] intArr = new int[arr.length];
        for(int i= 0;intArr.length>i;i++){
            intArr[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(Integer.toString(intArr[intArr.length-1]) + " " + Integer.toString(intArr[0]));
        Arrays.sort(intArr);
        return Integer.toString(intArr[intArr.length-1]) + " " + Integer.toString(intArr[0]);
    }
}
