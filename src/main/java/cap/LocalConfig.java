package cap;

import java.io.File;

public class LocalConfig {
    public static String PATH_IMGROOT = "D:/Img/";

    public static String PATH_USERIMG = "UserImg/";
    public static String PATH_IMGHEAD = "head/";
    public static String PATH_IMGS = "Imgs/";

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

    public static void setPathUserimg(String pathUserimg) {
        PATH_USERIMG = pathUserimg;
    }

    public static String getPathImghead() {
        return PATH_IMGROOT+PATH_IMGHEAD;
    }

    public static void setPathImghead(String pathImghead) {
        PATH_IMGHEAD = pathImghead;
    }

    public static String getPathImgs() {
        return PATH_IMGROOT + PATH_IMGS;
    }

    public static void setPathImgs(String pathImgs) {
        PATH_IMGS = pathImgs;
    }
}
