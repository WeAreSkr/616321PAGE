package cap.mvc.service;

import cap.mvc.dao.mapper.CommentMapper;
import cap.mvc.model.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {
    @Resource
    private CommentMapper commentMapper;

    public int addComment(Comment comment) {
        return  commentMapper.insert(comment);
    }

    public int delComment(Long id) {
        return  commentMapper.deleteByPrimaryKey(id);
    }

    public List<Comment> findCommentByPage(Long pageId){
       return commentMapper.selectByPage(pageId);
    }

}
