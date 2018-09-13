package cap.mvc.model;

public class Event {
    private Integer code; //内部标识

    private String title; //标题

    private Long content; //内容

    private String imgagesPath; //多张图片path

    private String editor; //编辑

    private Long dt;//日期

    private Integer stuNmb ;//谁发表的

    private Integer ispass;//是否通过了审核

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
        this.title = title == null ? null : title.trim();
    }

    public Long getContent() {
        return content;
    }

    public void setContent(Long content) {
        this.content = content;
    }

    public String getImgagesPath() {
        return imgagesPath;
    }

    public void setImgagesPath(String imgagesPath) {
        this.imgagesPath = imgagesPath == null ? null : imgagesPath.trim();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public Long getDt() {
        return dt;
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