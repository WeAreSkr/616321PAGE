package cap.util;

import java.io.File;
import java.util.Random;

public class FileName{

    /**
     * 获得一个合适的文件名
     * @param path 目录 的绝对路径 如 "c:/abc/" 返回 最后一个'/'不能少
     * @param suffix 扩展名  如 .jpg   '.'不能少
     * @return
     * null  不能得到相应的文件名
     * String 文件名
     */
    public static String getSuitableName(String path,String suffix) {
        String name = null;
        File file = null;
        for (int i = 0; i < 10; i++) {
            name = getRandomString(12) + suffix;
            file = new File(path + name);
            if (!file.exists())
                break;
            else
                name = null;
        }
        return name;
    }

    /**
     * 返回一个长度为length的随机字符串
     * @param length
     * @return
     */
    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 合并字符串
     * 中间加上 |
     * 如: ["abc","efg"] 和并为 "abc|efg"
     */
    public static String  mgStr(String[] strs) {
        String result = "";
        if(strs == null ) return  null;
        for( int i = 0; i< strs.length ; i++ ) {
            if(strs[i] != null) {
                if (strs.length - 1 == i)
                    result += strs[i];
                else
                    result += strs[i] + "|";
            }
        }
        return "".equals(result) ?  null : result;
    }

    /**
     * 把字符串以 '|'分开
     * 如 "abc|defg" 分为 ["abc","defg"]
     */
    public static String[] divStr(String strfiles) {
       return strfiles == null ? null :strfiles.split("[|]");
    }

}
