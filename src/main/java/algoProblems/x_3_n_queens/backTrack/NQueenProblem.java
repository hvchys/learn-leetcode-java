package algoProblems.x_3_n_queens.backTrack;

import static Util.randNum.shuffleArr;

public class NQueenProblem {
    public int size;
    public int[][] board;

    public NQueenProblem(int size){
        this.size = size;
        this.board = new int[size][size];
        initialize();
    }

    private void initialize(){
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                this.board[i][j] = 0;
            }
        }
    }

    // 打印结果
    private void printSolution() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++)
                if(this.board[i][j]==0){
                    System.out.print(" _ ");
                }else{
                    System.out.print(" " + this.board[i][j] + " ");
                }
            System.out.println();
        }
    }

    // 判断 往 board[row][col] 放queen, 是否安全
    private boolean isSafe(int row, int col) {
        int i, j;

        /* Check this row on left side */
        for (i = 0; i < col; i++)
            if (this.board[row][i] == 1)
                return false;

        /* Check upper diagonal on left side */
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (this.board[i][j] == 1)
                return false;

        /* Check lower diagonal on left side */
        for (i=row, j=col; j>=0 && i< this.size; i++, j--)
            if (this.board[i][j] == 1)
                return false;

        return true;
    }

    /*
       解决 N 皇后问题
       recursive func
       col: 表示现在已经摆了几个queen了
       col in [0, N-1]
       摆第 col 个 queen
     */
    private boolean solveNQUtil(int col) {
        // 都摆好了
        if (col >= this.size)
            return true;

        int[] arr = shuffleArr(this.size);
        // 对于第 col 列，看 queen 能不能被放在 board[i][col]
        // 改一下，增加随机性 !!!
        for (int k = 0; k < this.size; k++) {
            int i = arr[k];
            // 检查，board[i][col] 是否可用
            if (isSafe(i, col)) {
                // 放 第 col 个 queen
                this.board[i][col] = 1;

                // recur, 摆剩下的queen
                if (solveNQUtil(col + 1))
                    return true;

                // 虽然 board[i][col] 可用，但是往下走的话，某一步就不行了。
                // BACKTRACK，回溯 !!!!
                this.board[i][col] = 0; // BACKTRACK
            }
        }

        // 当前这个 col ，彻底不行
        return false;
    }


    public void getOneSolution() {
        if (!solveNQUtil(0)) {
            System.out.print("Solution does not exist");
            return ;
        }
        printSolution();
    }

    public void getAllSolution() {
        if (!solveNQUtil(0)) {
            System.out.print("Solution does not exist");
            return ;
        }
        printSolution();
    }

}