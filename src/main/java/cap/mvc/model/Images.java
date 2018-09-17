package cap.mvc.model;

public class Images {
    private Integer id;

    private String picPath;

    private String dsc;

    private Integer gro;

    private Long dt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getDsc() {
        return dsc;
    }

    public void setDsc(String dsc) {
        this.dsc = dsc;
    }

    public Integer getGro() {
        return gro;
    }

    public void setGro(Integer gro) {
        this.gro = gro;
    }

    public Long getDt() {
        return dt;
    }

    public void setDt(Long dt) {
        this.dt = dt;
    }
}