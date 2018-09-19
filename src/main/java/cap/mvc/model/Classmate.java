package cap.mvc.model;

public class Classmate {
    private Integer stuNmb;

    private Long pageId;

    private String name;

    private String nickname;

    private String pwd;

    private String dsc;

    private Integer authority;
    /**
     * 0 表示同学权限 ，有留言评论，查看隐私信息权限
     * 1 表示班长权限 ，有修改相册， 审核核级志的权限
     */
    private String headImg;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Integer getAuthority() {
        return authority;
    }

    public void setAuthority(Integer authority) {
        this.authority = authority;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }
}