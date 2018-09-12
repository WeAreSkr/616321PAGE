package cap;

import java.io.File;

public class LocalConfig {
    public final static String PATH_IMGROOT = "D:/Img/";

    public final static String PATH_USERIMG = "UserImg/";
    public final static String PATH_IMGHEAD = "head/";
    public final static String PATH_IMGS = "Imgs/";

    public static String noImg= PATH_IMGROOT+"noimg.jpg";

/**
 *
 * 创建相应的目录
 */
    static {
        File file = new File(PATH_IMGROOT);
        if(!file.exists()) {
            file.mkdir();
        }

        file = new File(PATH_IMGROOT+PATH_USERIMG);
        if(!file.exists()) {
            file.mkdir();
        }

        file = new File(PATH_IMGROOT+PATH_IMGHEAD);
        if(!file.exists()) {
            file.mkdir();
        }

        file = new File(PATH_IMGROOT+PATH_IMGS);
        if(!file.exists()) {
            file.mkdir();
        }
    }

    public static String getPathUserimg() {
        return PATH_IMGROOT+PATH_USERIMG;
    }

    public static String getPathImghead() {
        return PATH_IMGROOT+PATH_IMGHEAD;
    }

    public static String getPathImgs() {
        return PATH_IMGROOT + PATH_IMGS;
    }

}
