public class NumberFun {
    public static long findNextSquare(long sq) {
        if(sq != Math.floor(Math.sqrt(sq)) * Math.floor(Math.sqrt(sq))){
            return -1;
        }
        double tmp = Math.sqrt(sq);
        tmp++;
        return Math.round(tmp*tmp); 
    }
}
