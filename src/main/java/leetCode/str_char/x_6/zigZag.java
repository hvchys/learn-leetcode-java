package leetCode.str_char.x_6;

public class zigZag {

    public String convert(int eleNum, int numRows){
        int curRow = 0;
        boolean goDown = true;
        int i = 0;
        while(i < eleNum){


            i++;
            // 先考虑 curRow = 第一行/最后一行 的情况
            // 然后，就是普通情况了
            if(curRow == (numRows-1)){
                goDown = false;
                curRow--;
            }
            if(curRow == 0){
                curRow++;
                goDown = true;
            }
            if(goDown)
                curRow++;
            else
                curRow--;
        }
        return "";
    }

}
