package numbers;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SudokuValidator {

    public static boolean check(int[][] sudoku) {
        List<Integer> numbersLine = new ArrayList<>();
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                numbersLine.add(sudoku[i][j]);
            }
            Collections.sort(numbersLine);
            for (int k = 0; k < sudoku.length; k++) {
                if (numbersLine.get(k) != k + 1) {
                    return false;
                }
            }
            if (numbersLine.get(0) == 0) {
                return false;
            }
            numbersLine.clear();
        }
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                numbersLine.add(sudoku[j][i]);
            }
            Collections.sort(numbersLine);
            for (int k = 0; k < sudoku.length; k++) {
                if (numbersLine.get(k) != k + 1) {
                    return false;
                }
            }
            if (numbersLine.get(0) == 0) {
                return false;
            }
            numbersLine.clear();
        }

        for (int i = 0; i < sudoku.length; i += 3) {
            for (int j = 0; j < sudoku.length; j += 3) {
                return validGrids(sudoku);
            }
        }
        return true;
    }

    public static boolean validGrids(int[][] sudoku) {
        List<Integer> numbersGrids = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numbersGrids.add(sudoku[i][j]);
            }
        }
        Collections.sort(numbersGrids);
        for (int i = 0; i < 9; i++) {
            if (numbersGrids.get(i) != i + 1) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] sudoku = new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        boolean result = check(sudoku);
        System.out.println(result);

    }
}
