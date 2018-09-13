package cap.mvc.model;

public class Page {
    private Long pageId; //内部标识

    private Integer model; // 类型

    private String dsc; /*由于没想好page有哪些字段，我们直接生成保存个json对象*/

    private Long birthday; //生日

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public Integer getModel() {
        return model;
    }

    public void setModel(Integer model) {
        this.model = model;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageId=" + pageId +
                ", model=" + model +
                ", dsc='" + dsc + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}