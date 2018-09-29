package cap.mvc.service;

import cap.mvc.bean.PageEx;
import cap.mvc.dao.mapper.ClassmateMapper;
import cap.mvc.dao.mapper.PageMapper;
import cap.mvc.model.Classmate;
import cap.mvc.model.Page;
import cap.util.SavaHtml;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PageService {
    @Resource
    private PageMapper pageMapper;
    @Resource
    private ClassmateMapper classmateMapper;

    public PageEx findPageExByStuNmb(int stuNmb){
        Classmate classmate = classmateMapper.selectByPrimaryKey(stuNmb);
        if(classmate == null) return  null;
        Long  pageId = classmate.getPageId();
        Page page = pageMapper.selectByPrimaryKey(pageId);
        if(page == null) return  null;
        PageEx pageEx = JSON.parseObject(page.getDsc(),PageEx.class);
        if(pageEx == null) pageEx = new PageEx();
        pageEx.setPage(page);
        return  pageEx;
    }

    public int updatePageEx(PageEx pageEx,Classmate curUser) {
        if(curUser != null && pageEx != null && curUser.getPageId() == pageEx.getPageId())
            return  pageMapper.updateByPrimaryKey(pageEx.toPage());
        else
            return  0;
    }

    public boolean updateMd(Integer stuNmb,String md) {
        return SavaHtml.savaHtmlorMd(stuNmb+".md",md);
    }

    public String getMd(Integer stuNmb) {
        return SavaHtml.readHtmlorMd(stuNmb+".md");
    }

    public boolean updateHtmlEx(Integer stuNmb,String htmlex) {
        return SavaHtml.savaHtmlorMd(stuNmb+".html",htmlex);
    }

    public String getHtmlEx(Integer stuNmb) {
        return SavaHtml.readHtmlorMd(stuNmb+".html");
    }

}
