package cap.mvc.service;

import cap.mvc.dao.mapper.CommentsMapper;
import cap.mvc.model.Comments;
import cap.mvc.model.association.CommentsAs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {
    @Resource
    private CommentsMapper commentMapper;

    public int addComment(Comments comment) {
        return  commentMapper.insert(comment);
    }

    public int delComment(Long id) {
        return  commentMapper.deleteByPrimaryKey(id);
    }

    public List<CommentsAs> findCommentByPage(Long pageId){
       return commentMapper.selectByPage(pageId);
    }

}
