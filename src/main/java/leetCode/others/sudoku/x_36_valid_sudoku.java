package leetCode.others.sudoku;

import java.util.HashSet;
import java.util.Set;

public class x_36_valid_sudoku {
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

    public boolean isValidSudoku(char[][] board) {
        char[] curBlock;
        for(int i = 0; i < 9; i++){
            // 行
            curBlock = board[i];
            if(!isValidBlock(curBlock)){
                return false;
            }
            // 列
            curBlock = getCol(board, i);
            if(!isValidBlock(curBlock)){
                return false;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                // 小正方形
                curBlock = getSmallBoard(board, i, j);
                if(!isValidBlock(curBlock)){
                    return false;
                }
            }
        }
        return true;
    }

    public int getX(char c){
        int code = (int) c;
        if(code > 48 && code <= 57){
            return code - 48;
        } else if(code == 46){
            return -2; // 是 dot
        }else{
            return -1; // 啥都不是
        }
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
