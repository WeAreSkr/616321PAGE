package cap.mvc.dao;

import cap.LocalConfig;
import org.springframework.stereotype.Repository;
import java.io.*;

@Repository
public class CountDao {

    public  int getCount() {
        int result = 0;
        String filePath = LocalConfig.getCountfile();
        File file = new File(filePath);
        if(file.exists()) {
            try {
                    FileReader reader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(reader);
                    String s = bufferedReader.readLine();
                    reader.close();
                    result = Integer.valueOf(s);

            } catch (IOException e) {

                e.printStackTrace();
            }
        }else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  result;
    }

    public  void setCount(int count) {
        int c = getCount();
        String filePath = LocalConfig.getCountfile();

        File file = new File(filePath);
        try {
                PrintWriter printWriter = new PrintWriter(file);
                printWriter.print(count);
                printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
