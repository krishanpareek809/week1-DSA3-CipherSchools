public class Lecture9 {
    public static boolean placeQueens(int[][] board, int row) {
        if (row >= board.length) {
            printBoard(board);
        }

        for (int currentCellIndex = 0; currentCellIndex < board.length; currentCellIndex++) {
            if (isSafeToPlace(board, row, currentCellIndex)) {
                board[row][currentCellIndex] = 1;

                boolean canPlaceQueens = placeQueens(board, row + 1);
                if (canPlaceQueens) {
                    return true;
                }

                board[row][currentCellIndex] = 0; // backtrack
            }
        }

        return false;
    }

    private static void printBoard(int[][] board) {
        for(int row=0; row < board.length; row++){
            for(int col=0; col<board[0].length; col++){
                System.out.println(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isSafeToPlace(int[][] board, int currentRow, int currentCellIndex) {
        for (int row = 0; row < currentRow; row++) {
            if (board[row][currentCellIndex] == 1) {
                return false;
            }

            
        }

        int x = currentRow;
        int y = currentCellIndex;

        while(x >= 0 && y>= 0){
            if(board[x][y] == 1){
                return false;
            }
            x--;
            y--;
        }

        x = currentRow;
        y = currentCellIndex;

        while (x >= 0 && y < board.length) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }

        return true;
    }

    public static void main(String[] args) {
        
        int[][] board = new int[4][4];

        placeQueens(board, 0);
        }

}
