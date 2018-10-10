package cap.mvc.model.association;

import cap.mvc.model.Classmate;
import cap.mvc.model.Comments;
import cap.mvc.model.Page;

import java.util.List;

/**
 * 带关系的page
 * **/
public class PageAs extends Page{
    private Classmate classmate;
    private List<Comments> commentList;

    public Classmate getClassmate() {
        return classmate;
    }

    public void setClassmate(Classmate classmate) {
        this.classmate = classmate;
    }

    public List<Comments> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comments> commentList) {
        this.commentList = commentList;
    }

    @Override
    public String toString() {
        return "PageAs{" +
                "classmate=" + classmate +
                ", commentList=" + commentList +
                "} " + super.toString();
    }
}
