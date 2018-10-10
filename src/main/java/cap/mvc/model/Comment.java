package cap.mvc.model;

public class Comment {
    private Long commId;

    private Integer stuNmb;

    private Long pageId;

    private String msg;

    private Classmate classmate;
    public Classmate getClassmate() {
        return classmate;
    }

    public void setClassmate(Classmate classmate) {
        this.classmate = classmate;
    }
    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Integer getStuNmb() {
        return stuNmb;
    }

    public void setStuNmb(Integer stuNmb) {
        this.stuNmb = stuNmb;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commId=" + commId +
                ", stuNmb=" + stuNmb +
                ", pageId=" + pageId +
                ", msg='" + msg + '\'' +
                ", classmate=" + classmate +
                '}';
    }
}