package cap.mvc.model;

public class Classmate {
    private Integer stuNmb; //学号

    private Long pageId; // 主页

    private String name; //名字

    private String nickname; //昵称

    private String dsc; // 签名

    private Integer authority; // 权限

    private String headImg; // 头像路径

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
        this.name = name == null ? null : name.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc == null ? null : dsc.trim();
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
        this.headImg = headImg == null ? null : headImg.trim();
    }
}