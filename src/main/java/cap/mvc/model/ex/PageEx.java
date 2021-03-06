package cap.mvc.model.ex;

import cap.mvc.model.Page;
import com.alibaba.fastjson.JSON;

/**
 * 用来扩展page，其实也可以扩展classmate 因为classmate和page是一对一 ：-)
 */

public class PageEx extends Page {
    private String qq;
    private String phone;
    private String desc;


    /**
     * enum {"0","1"}
     */
    private Integer sex;
    public void setPage(Page page) {
        super.setBirthday(page.getBirthday());
        super.setModel(page.getModel());
        super.setPageId(page.getPageId());
        super.setDsc(page.getDsc());
    }

    public Page toPage() {
        Page page = new Page();
        page.setBirthday(this.getBirthday());
        page.setModel(this.getModel());
        page.setPageId(this.getPageId());
        page.setDsc(JSON.toJSONString(this));
        return  page;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "PageEx{" +
                "qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", desc='" + desc + '\'' +
                ", sex='" + sex + '\'' +
                "} " + super.toString();
    }
}
