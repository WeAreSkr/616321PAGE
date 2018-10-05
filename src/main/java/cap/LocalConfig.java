package cap;

import java.io.File;

public class LocalConfig {

    private final static String PATH_IMGROOT = "/home/liubailin/img/";
    private final static String PATH_USERIMG = "userimg/";
    private final static String PATH_IMGHEAD = "head/";
    private final static String PATH_IMGS = "imgs/";
    private final static String PATH_IMGSEVENT = "eventimgs/";

    public static String noImg= PATH_IMGROOT+"noimg.jpg";

    private final static String PATH_PAGE = "/home/liubailin/html/";

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
        file = new File(PATH_IMGROOT+PATH_IMGSEVENT);
        if(!file.exists()) {
            file.mkdir();
        }

        file = new File(PATH_PAGE);
        if(!file.exists()) {
            file.mkdir();
        }
        System.out.println("检测文件系统完成");

    }

    public static String getPathImgUser() {
        return PATH_IMGROOT+PATH_USERIMG;
    }

    public static String getPathImghead() {
        return PATH_IMGROOT+PATH_IMGHEAD;
    }

    public static String getPathImgs() {
        return PATH_IMGROOT + PATH_IMGS;
    }

    public static String getPathImgsEvent() {
        return PATH_IMGROOT+PATH_IMGSEVENT;
    }



    /***-------------------------***/
    public static String getPathPage() {
        return PATH_PAGE;
    }


}
