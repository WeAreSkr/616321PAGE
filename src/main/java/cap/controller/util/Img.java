package cap.controller.util;

import cap.LocalConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 图片资源
 */
@Controller
@RequestMapping("/")
public class Img {
    @RequestMapping("img/{dirimg}/{img:.+}")
    public void imgs(@PathVariable("dirimg") String imgpath,@PathVariable(value = "img") String iconUrl, HttpServletResponse response) {
        String filePath = null;
        System.out.println(iconUrl);
        if(imgpath.equals("imgs")) {
            filePath = LocalConfig.getPathImgs() + iconUrl;
        }else if(imgpath.equals("head")) {
            filePath = LocalConfig.getPathImghead() + iconUrl;
        }else if(imgpath.equals("userImg")) {
            filePath = LocalConfig.getPathUserimg() + iconUrl;
        }else {
            filePath = LocalConfig.noImg;
        }

        File file = new File(filePath);
        FileInputStream fis = null;
        try {
            response.setContentType("image/jpg");
            OutputStream out = response.getOutputStream();
            fis = new FileInputStream(file);

            byte[] b = new byte[fis.available()];
            fis.read(b);
            out.write(b);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @RequestMapping(value = "/uploadimage",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String uploadImage(HttpServletRequest request,
                              HttpServletResponse response,@RequestParam(value = "imgs", required = true) MultipartFile file)
            throws IllegalStateException, IOException {

        File targetFile = new File(LocalConfig.getPathImgs()+"test.jpg");
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        file.transferTo(targetFile);
        return "redirect:/index.jsp";
    }

}
