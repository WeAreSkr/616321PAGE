package cap.mvc.controller;

import cap.LocalConfig;
import cap.mvc.bean.Msg;
import cap.mvc.model.Images;
import cap.mvc.service.ImageService;
import cap.util.FileName;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/")
public class ImageController {

    @Resource
    private ImageService imageService;

    @RequestMapping(value = "photo",method = RequestMethod.GET)
    public ModelAndView photo(Model model) {
       model.addAttribute("images",imageService.findAll());
        return new ModelAndView("photo");
    }

    @RequestMapping(value = "/authority/1/addimgs",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String addEvent(Model model, Images images, @RequestParam(value = "imgs", required = true) MultipartFile[] files) {
        int count = 0;
        Msg msg = new Msg("上传文件",0,"");
        String[] fileNames = new String[files.length];
        for(int i = 0; i< files.length; i++) {
            fileNames[i] = FileName.getSuitableName(LocalConfig.getPathImgs(),".jpg");
            if(fileNames[i] == null) {
                 msg.setCode(1);
                msg.setMsg("无法创建图片文件");
            }else if ( files[i].getSize() == 0){
                fileNames[i] =null; //如果为null就不保存
            }  else{
                File targetFile = new File(LocalConfig.getPathImgs() + fileNames[i]);
                File targetFileScale = new File(LocalConfig.getPathImgs() + fileNames[i]+".jpg");
                try {
                    Thumbnails.of(files[i].getInputStream()).size(320,240).toFile(targetFileScale);
                    files[i].transferTo(targetFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                images.setDt(new Date().getTime());
                images.setPicPath(fileNames[i]);
                imageService.addImage(images);
                count ++;
            }
        }
        msg.setMsg("上传：" +count +"张");
        model.addAttribute(msg);
        return "result";
    }

    @RequestMapping(value = "/authority/1/addimgs",method = RequestMethod.GET)
    public String addImgs(Model model, HttpServletRequest request, HttpServletResponse response) {
        return "/authority/1/addimgs";
    }

}
