package cap.mvc.model;

public class Comment {
    private Long commId; //id标识

    private Integer stuNmb; //谁发表的

    private Long pageId; // 哪张主页下的

    private String msg; //信息

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
        this.msg = msg == null ? null : msg.trim();
    }
}