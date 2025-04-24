package Matrix;

public class ValidSudoku {
    
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if(!isValidUnit(board[i]) || !isValidUnit(getColumn(board, i))){
                return false;
            }
        }

        for (int row = 0; row < 9; row+=3) {
            for (int column = 0; column < 9; column+=3) {
                if(!isValidBox(board, row, column)){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isValidUnit(char[] unit){
        boolean seen[] = new boolean[9];
        for (char num : unit) {
            if(num != '.'){
                int digit =  num - '1'; 
                if(seen[digit]){
                    return false;
                }
                seen[digit] = true;
            }
        }
        return true;
    }

    public static boolean isValidBox(char[][] board, int startRow, int startColumn){
        boolean seen[] = new boolean[9];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                char num = board[startRow + row][startColumn + col];
                if(num != '.'){
                    int digit = num - '1';
                    if(seen[digit]){
                        return false;
                    }
                    seen[digit] = true;
                }
            }
        }
        return true;
    }

    public static char[] getColumn(char[][] board, int col){
        char[] column = new char[9];
        for (int i = 0; i < 9; i++) {
            column[i] = board[i][col];
        }
        return column;
    }

    public static void main(String[] args) {
        char[][] board1 = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board1));
    }    
}
