import java.util.HashMap;
import java.util.Map;

public class BattleShips {
    private static final String SUNK = "sunk";
    private static final String DAMAGED = "damaged";
    private static final String NOT_TOUCHED = "notTouched";
    private static final String POINTS = "points";

    public static Map<String, Double> damagedOrSunk(final int[][] board, final int[][] attacks) {

        Map<Integer, Integer> shipPre = new HashMap<>();
        Map<Integer, Integer> shipPost = new HashMap<>();
        Map<String, Double> points = new HashMap<>();

        checkBoard(board, shipsPre);
        runAttacks(board, attacks);
        checkBoard(board, shipsPost);
        checkGame(shipsPre, shipsPost, points);
        calcPoins(points);

        return points;
    }

    private static void calcPoints(Map<String, Double> points) {
        points.put(SUNK, points.getOrDefault(SUNK, 0.0));
        points.put(DAMAGED, points.getOrDefault(DAMAGED, 0.0));
        points.put(NOT_TOUCHED, points.getOrDefault(NOT_TOUCHED, 0.0));
        points.put(POINTS, (points.getOrDefault(SUNK, 0.0) * 1.0) + (points.getOrDefault(DAMAGED, 0.0) * 0.5) + (points.getOrDefault(NOT_TOUCHED, 0.0) * -1.0));
    }

    private static void checkGame(Map<Integer, Integer> shipPre, Map<Integer, Integer> shipPost, Map<String, Double> points) {
        shipPre.forEach((key, valPre) -> {
            Integer valPost = shipPost.getOrDefault(key, 0);
            if (valPre == valPost) points.put(NOT_TOUCHED, 1 + points.getOrDefault(NOT_TOUCHED, 0.0));
            else if (valPost > 0) points.put(DAMAGED, 1 + points.getOrDefault(DAMAGED, 0.0));
            else if (valPost == 0) points.put(SUNK, 1 + points.getOrDefault(SUNK, 0.0));
        });
    }

    private static void runAttacks(int[][] board, int[][] attacks) {
        for (int[] attack : attacks) {
            board[board.length - attack[1]][attack[0] - 1] = 0;
        }
    }

    private static void checkBoard(int[][] board, Map<Integer, Integer> shipPre) {
        for (int[] row : board) {
            for (int i : row) {
                if (i > 0) shipPre.put(i, 1 + shipPre.getOrDefault(i, 0));
            }
        }
    }
}
