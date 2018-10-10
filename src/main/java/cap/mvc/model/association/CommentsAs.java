package cap.mvc.model.association;

import cap.mvc.model.Classmate;
import cap.mvc.model.Comments;

public class CommentsAs extends Comments{
    private Classmate classmate;

    public Classmate getClassmate() {
        return classmate;
    }

    public void setClassmate(Classmate classmate) {
        this.classmate = classmate;
    }

    @Override
    public String toString() {
        return "CommentsAs{" +
                "classmate=" + classmate +
                '}';
    }
}
