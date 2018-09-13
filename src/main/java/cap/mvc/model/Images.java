package cap.mvc.model;

public class Images {
    private String picPath; //图片path

    private String dsc; //描绘

    private Integer gro;//组

    private Long dt; //日期

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

    @Override
    public String toString() {
        return "Images{" +
                "picPath='" + picPath + '\'' +
                ", dsc='" + dsc + '\'' +
                ", gro=" + gro +
                ", dt=" + dt +
                '}';
    }
}