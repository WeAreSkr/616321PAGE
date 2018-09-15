package cap.mvc.bean;

public class Msg {

    private String title;

    private int code;

    private String msg;

    public Msg() {
    }

    public Msg(String title, int code, String msg) {
        this.title = title;
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
