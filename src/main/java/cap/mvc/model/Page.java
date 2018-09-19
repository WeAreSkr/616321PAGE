package cap.mvc.model;

public class Page {
    private Long pageId;

    private Integer model;

    private String dsc;

    private Long birthday;

    public Page() {
    }
    public Page(Page page) {
        this.pageId = page.pageId;
        this.model = page.model;
        this.dsc = page.dsc;
        this.birthday = page.birthday;
    }
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