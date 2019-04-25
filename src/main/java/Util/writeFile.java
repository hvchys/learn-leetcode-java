package Util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangweichen on 2017/8/1.
 */
public class writeFile {

    public static void wirteAns(String inputPath, String content){
        try{
            File fileName = new File(inputPath);
            List<String> preList = new ArrayList<String>();
            if(fileName.exists()){
                preList = getPreFile(inputPath); // 读入文件之前的内容
            }else{
                fileName.createNewFile(); // 创建新文件
            }

            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
            for(int i = 0; i < preList.size(); i++){ // 写入 之前的内容
                out.write(preList.get(i) + "\n");
            }
            out.write(content + "\n---------------------------hvc_test-------------------------------");
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        }catch (Exception e){
            System.out.println("xx_writeFile error!!!");
        }
    }

    public static List<String> getPreFile(String filePath){
        List<String> preList = new ArrayList<String>();
        File fileName = new File(filePath);
        try{
            BufferedReader in = new BufferedReader(new FileReader(fileName.getAbsolutePath()));
            String preLine = "";
            while((preLine = in.readLine()) != null){
                preList.add(preLine);
            }
            in.close();
        }catch (Exception e){
            System.out.println("getPreFile error!!!");
        }
        return preList;
    }


}
