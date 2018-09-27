package cap.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class ImageController {
    @RequestMapping(value = "photo",method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("photo");
    }

}
