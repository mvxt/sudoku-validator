import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Sudoku {

    /**
     * Method checks the validity of a Sudoku puzzle
     * by scanning the rows, columns, and each 3x3 grid
     * for nums 1-9, unique.
     *
     * @param sudoku - int[][]
     */
    public static boolean checkValidity(int[][] sudoku) {
        // Check we have 9 rows
        if (sudoku.length != 9) {
            return false;
        }

        // For every row...
        for (int i = 0; i < sudoku.length; i++) {
            // Check we have 9 columns in row
            if (sudoku[i].length != 9) {
                return false;
            }

            HashSet<Integer> nums = new HashSet<>();
            // For every column in row...
            for (int j = 0; j < sudoku[i].length; j++) {
                int current = sudoku[i][j];

                // Invalid if not 1 <= X <= 9
                if (current < 1 || current > 9) {
                    return false;
                }

                // Check uniqueness
                if (nums.contains(current)) {
                    return false;
                } else {
                    nums.add(current);
                }
            }
        }

        // Repeat w/ swapped i/j for column checks
        // Since it passed the first iteration, we can 
        // assume:
        // - Input is a valid 9 x 9 grid
        // - There are no numbers < 1 or > 9
        for (int i = 0; i < sudoku[0].length; i++) {
            HashSet<Integer> nums = new HashSet<>();
            for (int j = 0; j < sudoku.length; j++) {
                int current = sudoku[j][i];
                if (nums.contains(current)) {
                    return false;
                } else {
                    nums.add(current);
                }
            }
        }

        // Check 3x3 squares. Each square is offset
        // by 3 on row or column side.
        for (int rows = 0; rows < 3; rows++) {
            int currentBoxRow = 3 * rows;
            for (int cols = 0; cols < 3; cols++) {
                int currentBoxCol = 3 * cols;
                HashSet<Integer> nums = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int current = sudoku[currentBoxRow + i][currentBoxCol + j];
                        if (nums.contains(current)) {
                            return false;
                        } else {
                            nums.add(current);
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<int[][]> tests = new ArrayList<>();
        
        // Valid solution
        int[][] valid = new int[][]{
            {4,2,5,3,7,1,9,8,6},
            {6,9,3,4,8,2,5,7,1},
            {7,1,8,9,6,5,3,2,4},
            {3,5,2,8,4,9,1,6,7},
            {9,8,7,1,2,6,4,3,5},
            {1,6,4,7,5,3,2,9,8},
            {8,3,6,5,9,4,7,1,2},
            {2,4,1,6,3,7,8,5,9},
            {5,7,9,2,1,8,6,4,3}
        };
        tests.add(valid);
        
        // Invalid because of repetition in row
        int[][] invalid1 = new int[][]{
            {4,4,5,3,7,1,9,8,6},
            {6,9,3,4,8,2,5,7,1},
            {7,1,8,9,6,5,3,2,4},
            {3,5,2,8,4,9,1,6,7},
            {9,8,7,1,2,6,4,3,5},
            {1,6,4,7,5,3,2,9,8},
            {8,3,6,5,9,4,7,1,2},
            {2,4,1,6,3,7,8,5,9},
            {5,7,9,2,1,8,6,4,3}
        };
        tests.add(invalid1);

        // Invalid because of repetition in column
        int[][] invalid2 = new int[][]{
            {4,2,5,3,7,1,9,8,6},
            {4,9,3,4,8,2,5,7,1},
            {7,1,8,9,6,5,3,2,4},
            {3,5,2,8,4,9,1,6,7},
            {9,8,7,1,2,6,4,3,5},
            {1,6,4,7,5,3,2,9,8},
            {8,3,6,5,9,4,7,1,2},
            {2,4,1,6,3,7,8,5,9},
            {5,7,9,2,1,8,6,4,3}
        };
        tests.add(invalid2);
        
        // Invalid because invalid value(s) present
        int[][] invalid3 = new int[][]{
            {4,2,5,3,7,1,9,8,6},
            {6,9,10,4,8,2,5,7,1},
            {7,1,8,9,6,5,3,2,4},
            {3,5,2,8,4,9,1,6,7},
            {9,8,7,1,2,6,4,3,5},
            {1,6,4,7,5,3,2,9,8},
            {8,3,6,5,9,4,15,1,2},
            {2,4,1,6,3,7,8,5,9},
            {5,7,9,2,1,8,6,4,3}
        };
        tests.add(invalid3);
        
        // Invalid because invalid row / column present
        int[][] invalid4 = new int[][]{
            {4,2,5,3,7,1,9,8,6},
            {6,9,3,4,8,2,5,7,1},
            {7,1,8,9,6,5,3,2,4},
            {3,5,2,8,4,9,1,6,7},
            {9,8,7,1,2,6,4,3,5},
            {1,6,4,7,5,3,2,9,8},
            {8,3,6,5,9,4,7,1,2},
            {2,4,1,6,3,7,8,5,9},
            {5,7,9,2,1,8,6,4}
        };
        tests.add(invalid4);
        
        // Invalid because invalid box(es)
        int[][] invalid5 = new int[][]{
            {4,2,5,3,7,1,9,8,6},
            {6,9,3,4,8,2,5,7,1},
            {7,1,4,9,6,5,3,2,4},
            {3,5,2,8,4,9,1,6,7},
            {9,8,7,1,2,6,4,3,5},
            {1,6,4,7,5,3,2,9,8},
            {8,3,6,5,9,4,7,1,2},
            {2,4,1,6,3,7,8,5,9},
            {5,7,9,2,1,8,6,4,5}
        };
        tests.add(invalid5);
        
        for (int[][] test : tests) {
            System.out.println(checkValidity(test));
        }

    }
}
