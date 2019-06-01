package leetCode.others.x_36_sudoku;


import java.util.HashSet;


class Blank{
    boolean isBlank;
    HashSet<Integer> set;
    int choiceNum;

    Blank(){
        this.isBlank = false;
    }

    static Blank getBlank(){
        Blank b = new Blank();
        b.isBlank = true;
        b.set = new HashSet<>();
        b.choiceNum = 0;
        return b;
    }
}

class Position{
    int x;
    int y;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Choices{
    Position[] arr;
    int i;
    int j;

    Choices(int i, int j){
        this.i = i;
        this.j = j;
    }

}


public class x_37_sudoku_solver {
    /*
    Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    1 Each row must contain the digits 1-9 without repetition.
    2 Each column must contain the digits 1-9 without repetition.
    3 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    某一行的输入:
    ["8","3",".",".","7",".",".",".","."]

    ".": 46
    int: 对应的 char 的编码: (1: 49) ~ (9: 57)
     */

    /*
    大概是，深度搜索: 搜的时候，找可能的解少的点填
    填一个数，如果可以，继续往下走，如果不行，一点点往回退

    利用规则先把能填的填了: 要么有能填的，要么就是解不唯一

     */

    public void solveSudoku(char[][] board) {
        Integer[][] boardInt = new Integer[9][9];
        Blank[][] blanks = new Blank[9][9];
        int leftNum = GetInfo.initializeBoard(board, boardInt, blanks);
        for(int k = leftNum; k >= 0; k--){
            update(leftNum, boardInt, blanks);
        }

        /*
        第 i 行, 第 j 列个block: (i,j = 0,1,2): 3*i ~ 3*j
         */

        // 第 i 行:
        int i = 1;


    }


    public boolean update(int leftNum, Integer[][] boardInt, Blank[][] blanks){
        /*
        第1行: deltaX = 0
        第2行: deltaX = 3: [deltaX + i, j]
        第3行: deltaX = 6
         */

        return false;
    }








}

class GetInfo{

    public static int initializeBoard(char[][] board, Integer[][] broadInt, Blank[][] blanks){
        int count = 0;
        int x;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                x = charToInt(board[i][j]);
                broadInt[i][j] = x;
                if(x == 0){
                    blanks[i][j] = Blank.getBlank();
                    count++;
                }
            }
        }
        return count;
    }

    public static int charToInt(char c){
        int code = (int) c;
        if(code > 48 && code <= 57){ // 1~9
            return code - 48;
        }
        return 0; // 是 dot
    }

    public static char intToChar(int x){
        return (char) (x + 48);
    }

    public static HashSet<Integer> getBlockInfo(Integer[][] boardInt, int i, int j){
        // 返回 这个 block 里面的元素集合
        // i,j: 0,1,2
        HashSet<Integer> ans = new HashSet<>();
        int startX = i*3;
        int startY = j*3;
        for(int deltaX = 0; deltaX < 3; deltaX++){
            for(int deltaY = 0; deltaY < 3; deltaY++){
                ans.add(boardInt[startX + deltaX][startY + deltaY]);
            }
        }
        ans.remove(0);
        return ans;
    }

    public static HashSet<Integer> getRowInfo(Integer[][] boardInt, int i){
        // 返回 第 i 行 里面的元素集合
        HashSet<Integer> ans = new HashSet<>();
        for(int k = 0; k < 9; k++){
            ans.add(boardInt[i][k]);
        }
        ans.remove(0);
        return ans;
    }

    public static HashSet<Integer> getColInfo(Integer[][] boardInt, int j){
        // 返回 第 j 列 里面的元素集合
        HashSet<Integer> ans = new HashSet<>();
        for(int k = 0; k < 9; k++){
            ans.add(boardInt[k][j]);
        }
        ans.remove(0);
        return ans;
    }

}

class CheckVal {
    public static boolean checkOnePlaceOneVal(Integer[][] boardInt, int i, int j, int block_i, int block_j, int x){

        return true;
    }

}

class Rule1 {
    // idx_X_left:
    // 行: block 是 第X行 之外的所有可能行
    // 列: block 是 第X列 之外的所有可能列
    static int[] idx_0_left = getPossibleIdx(0);
    static int[] idx_1_left = getPossibleIdx(1);
    static int[] idx_2_left = getPossibleIdx(2);

    public static boolean applyOnRow(Integer[][] boardInt, int i){
        // 对 第 i 行 的 block, 应用 规则1
        int occurTime, i_temp, j_temp, i_real, j_real, i_real_start, j_real_start;
        // 0,1,2 列
        HashSet<Integer> block0 = GetInfo.getBlockInfo(boardInt, i, 0);
        HashSet<Integer> block1 = GetInfo.getBlockInfo(boardInt, i, 1);
        HashSet<Integer> block2 = GetInfo.getBlockInfo(boardInt, i, 2);

        HashSet<Integer> row0 = GetInfo.getRowInfo(boardInt, i*3);
        HashSet<Integer> row1 = GetInfo.getRowInfo(boardInt, i*3+1);
        HashSet<Integer> row2 = GetInfo.getRowInfo(boardInt, i*3+2);

        for(int x = 1; x < 10; x++){
            occurTime = Rule1.getOccurTime(x, block0, block1, block2);
            if(occurTime == 2){
                i_temp = Rule1.rule1GetBlock(x, row0, row1, row2);
                j_temp = Rule1.rule1GetBlock(x, block0, block1, block2);
                // x 在 block(i_temp, j_temp) 行 出现
                i_real = i*3 + i_temp;
                // 检查 x=i_real, y= (j_real_start, *+2) 这三个数
                // 它们属于 block(i, j_temp)
                if(checkUpdateCol(x, i_real, i, j_temp, boardInt)){
                    return true; // 成功添加了一个
                }
            }
        }
        return false; // 没有可以添加的了
    }

    public static boolean checkUpdateCol(int x, int cur_i, int block_i, int block_j, Integer[][] boardInt){
        /*
            检查 某个 block 里面的 【某一行】，对于 这三个数，只检查它们的【列】
            x=i_real, y= (j_real_start, *+2) 这三个数
            希望: 这三个数，有且仅有一个 可以是 x
            如果成功添加，返回 true
         */

        int[] row_idx_left;
        if(block_i == 0){
            row_idx_left = idx_0_left;
        }else if(block_i == 1){
            row_idx_left = idx_1_left;
        }else{
            row_idx_left = idx_2_left;
        }

        boolean[] canBeX = new boolean[3]; // 默认值是 false
        int cur_j, j_start = block_j*3;
        for(int k = 0; k < 3; k++){
            cur_j = j_start + k;
            if(boardInt[cur_i][cur_j] == 0){ // 这个 spot 得是 空的
                canBeX[k] = checkCol_CanBeX(x, row_idx_left, cur_j, boardInt);
            }
        }
        // 如果 canBeX 有且仅有一个是 true, 就可以了
        int tempIdx = checkBoolArr(canBeX);
        if(tempIdx == -1){
            return false;
        }else{
            boardInt[cur_i][block_j*3+tempIdx] = x;
            return true;
        }
    }


    public static boolean applyOnCol(Integer[][] boardInt, int j){
        // 对 第 j 列 的 block, 应用 规则1
        int occurTime, i_temp, j_temp, i_real, j_real, i_real_start, j_real_start;
        // 0,1,2 行
        HashSet<Integer> block0 = GetInfo.getBlockInfo(boardInt, 0, j);
        HashSet<Integer> block1 = GetInfo.getBlockInfo(boardInt, 1, j);
        HashSet<Integer> block2 = GetInfo.getBlockInfo(boardInt, 2, j);

        HashSet<Integer> col0 = GetInfo.getColInfo(boardInt, j*3);
        HashSet<Integer> col1 = GetInfo.getColInfo(boardInt, j*3+1);
        HashSet<Integer> col2 = GetInfo.getColInfo(boardInt, j*3+2);

        for(int x = 1; x < 10; x++){
            occurTime = Rule1.getOccurTime(x, block0, block1, block2);
            if(occurTime == 2){
                i_temp = Rule1.rule1GetBlock(x, block0, block1, block2);
                j_temp = Rule1.rule1GetBlock(x, col0, col1, col2);
                // x 在 block(i_temp, j) 出现
                i_real_start = i_temp*3;
                j_real = j*3 + j_temp;
                // 检查 x=(i_real_start, *+2), j= j_real 这三个数
                // 它们属于 block(i_temp, j)
                if(checkUpdateRow(x, j_real, i_temp, j, boardInt)){
                    return true; // 成功添加了一个
                }
            }
        }
        return false; // 没有可以添加的了
    }

    public static boolean checkUpdateRow(int x, int cur_j, int block_i, int block_j, Integer[][] boardInt){
        /*
            检查 某个 block 里面的 【某一列】，对于 这三个数，只检查它们的【行】
            x=(i_real_start, *+2), j= j_real 这三个数
            希望: 这三个数，有且仅有一个 可以是 x
            如果成功添加，返回 true
         */

        int[] col_idx_left;
        if(block_j == 0){
            col_idx_left = idx_0_left;
        }else if(block_j == 1){
            col_idx_left = idx_1_left;
        }else{
            col_idx_left = idx_2_left;
        }

        boolean[] canBeX = new boolean[3]; // 默认值是 false
        int cur_i, i_start = block_i*3;
        for(int k = 0; k < 3; k++){
            cur_i = i_start + k;
            if(boardInt[cur_i][cur_j] == 0){ // 这个 spot 得是 空的
                canBeX[k] = checkRow_CanBeX(x, col_idx_left, cur_i, boardInt);
            }
        }
        // 如果 canBeX 有且仅有一个是 true, 就可以了
        int tempIdx = checkBoolArr(canBeX);
        if(tempIdx == -1){
            return false;
        }else{
            boardInt[block_i*3+tempIdx][cur_j] = x;
            return true;
        }
    }


    public static boolean checkCol_CanBeX(int x, int[] row_left, int cur_j, Integer[][] boardInt){
        for(int row_idx: row_left){
            if(boardInt[row_idx][cur_j] == x){
                return false;
            }
        }
        return true;
    }

    public static boolean checkRow_CanBeX(int x, int[] col_left, int cur_i, Integer[][] boardInt){
        for(int col_idx: col_left){
            if(boardInt[cur_i][col_idx] == x){
                return false;
            }
        }
        return true;
    }

    public static int checkBoolArr(boolean[] canBeX){
        /*
        如果 canBeX 有且仅有一个是 true, 返回它的 idx
        否则，返回 -1
        不可能没有 true, true的个数: 1,2,3
         */
        int tNum = 0;
        int ansIdx = -1;
        for(int i = 0; i < 3; i++){
            if(canBeX[i]){
                tNum++;
                ansIdx = i;
            }
        }
        if(tNum == 1){
            return ansIdx;
        }else{
            return -1;
        }
    }

    public static int getOccurTime(int x, HashSet<Integer> set0, HashSet<Integer> set1, HashSet<Integer> set2){
        int count = 0;
        if(set1.contains(x)){
            count++;
        }
        if(set2.contains(x)){
            count++;
        }
        if(set0.contains(x)){
            count++;
        }
        return count;
    }

    public static int rule1GetBlock(int x, HashSet<Integer> set0, HashSet<Integer> set1, HashSet<Integer> set2){
        // x 出现了两次，看 x 在 哪个set 里面 没有出现
        if(set0.contains(x)){
            if(set1.contains(x)){ // 0,1
                return 2;
            }else{ // 0,2
                return 1;
            }
        }else{ // 1,2
            return 0;
        }
    }

    public static int[] getPossibleIdx(int cur_i){
        /*
        计算: 是 cur_i行 之外的所有可能行
        或者，是 cur_i列 之外的所有可能列
         */
        int[] ans = new int[6];
        // cur_i*3: 0,1,2
        int lower = cur_i*3;
        int upper = cur_i*3 + 2;
        int idx = 0;
        for(int i = 0; i < 9; i++){
            if(i < lower || i > upper){
                ans[idx] = i;
                idx++;
            }
        }
        return ans;
    }
}

