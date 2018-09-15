package cap.mvc.model;

import cap.util.FileName;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Event {
    private Integer code;

    @NotEmpty(message = "标题不能为空哦")
    @Size(max = 1024 ,message = "最大输入1024个字")
    private String title;
    @Size(max =  2048 ,message = "最大输入2048个字")
    private String content;

    private String imgagesPath;

    @Size(max = 12,message = "最大输入12个字")
    private String editor;

    private Long dt;

    private Integer stuNmb;

    private Integer ispass;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgagesPath() {
        return imgagesPath;
    }
    public String[] getDivPath() {
        return FileName.divStr(getImgagesPath());
    }

    public void setImgagesPath(String imgagesPath) {
        this.imgagesPath = imgagesPath;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Long getDt() {
        return dt;
    }
    public String getFormatDt(){
        Date date = new Date(getDt());
        return  date.toString();
    }
    public void setDt(Long dt) {
        this.dt = dt;
    }

    public Integer getStuNmb() {
        return stuNmb;
    }

    public void setStuNmb(Integer stuNmb) {
        this.stuNmb = stuNmb;
    }

    public Integer getIspass() {
        return ispass;
    }

    public void setIspass(Integer ispass) {
        this.ispass = ispass;
    }
}