package cap.util;

import java.io.File;
import java.util.Random;

public class FileName{
    /**
     * 获得一个合适的文件名
     * @param path
     * @param suffix
     * @return
     */
    public static String getSuitableName(String path,String suffix) {
        String name = null;
        File file = null;
        for (int i = 0; i < 10; i++) {
            name = getRandomString(7) + suffix;;
            file = new File(path + getRandomString(7) + suffix);
            if (!file.exists())
                break;
            else
                name = null;
        }
        return name;
    }

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
     * @param strs
     * @return
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
     * 分开字符串
     * @param strfiles
     * @return
     */
    public static String[] divStr(String strfiles) {
       return strfiles == null ? null :strfiles.split("[|]");
    }

}
