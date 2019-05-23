package leetCode.others.sudoku;

import java.util.HashSet;
import java.util.Set;

public class x_37_sudoku_solver {
    /*
    Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    1 Each row must contain the digits 1-9 without repetition.
    2 Each column must contain the digits 1-9 without repetition.
    3 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    某一行的输入:
    ["8","3",".",".","7",".",".",".","."]

    ".": 46
    int: 对应的 char 的编码: (0: 48) ~ (9: 57)
     */

    /*
    大概是，深度搜索:
    填一个数，如果可以，继续往下走，如果不行，一点点往回退
     */
    public void solveSudoku(char[][] board) {


    }

    public char intToChar(int x){
        return (char) (x + 48);
    }

    public int getX(char c){
        int code = (int) c;
        if(code > 48 && code <= 57){
            return code - 48;
        }
        return -1; // 是 dot
    }

    public char[] getCol(char[][] board, int j){
        char[] ans = new char[9];
        for(int i = 0; i < 9; i++){
            ans[i] = board[i][j];
        }
        return ans;
    }

    public char[] getSmallBoard(char[][] board, int i, int j){
        /*
        i: 0
           3
           6
        j: 012 345
         */
        char[] ans = new char[9];
        int idx = 0;
        int i_start = i*3;
        int j_start = j*3;
        for(int delta_i = 0; delta_i < 3; delta_i++){
            for(int delta_j = 0; delta_j < 3; delta_j++){
                ans[idx] = board[i_start + delta_i][j_start + delta_j];
                idx++;
            }
        }
        return ans;
    }

    public boolean isValidBlock(char[] block){
        Set<Integer> numericSet = new HashSet<>();
        int x;
        for(char c: block){
            x = getX(c);
            if(x >= 0){
                // 是 数字
                if(numericSet.contains(x)){
                    return false;
                } else {
                    numericSet.add(x);
                }

            }else if(x == -1){
                // 不是数字 也 不是 dot
                return false;
            }
        }
        return true;
    }

}
