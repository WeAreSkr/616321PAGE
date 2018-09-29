package cap.util;

import cap.LocalConfig;

import java.io.*;

public class SavaHtml {

    /**
     * 保存html 或md文件
     * @param name 文件名
     * @param content 内容
     * @return
     * true 成功
     * flase 失败
     */
        public static Boolean savaHtmlorMd(String name,String content) {
            File file = new File(LocalConfig.getPathPage()+name);

            if(!file.exists()){
                try {
                    System.out.println(file.getAbsoluteFile());
                    file.createNewFile();
                } catch (IOException e) {
                    System.out.println("*****文件创建失败******");
                    e.printStackTrace();
                }
            }else if(!file.isFile()){
                return  false;
            }

            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(content.getBytes("UTF-8"));
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        }

    /**
     * 读取html或md文件
     * @param name
     * @return 文件内容
     */
    public static String readHtmlorMd(String name){
            File file = new File(LocalConfig.getPathPage()+name);
            if(!file.exists()) return null;
            String result = "";
            try {
                InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
                BufferedReader br = new BufferedReader(reader);
                StringBuilder builder = new StringBuilder();
                String s = null;
                while((s=br.readLine())!=null){
                    builder.append(s+"\n");
                }
                result = builder.toString();
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }
}

