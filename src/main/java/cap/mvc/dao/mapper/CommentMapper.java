package cap.mvc.dao.mapper;

import cap.mvc.dao.mapper.custom.CustomCommentMapper;
import cap.mvc.model.Comment;
import org.springframework.stereotype.Repository;
@Repository

public interface CommentMapper extends CustomCommentMapper{
    int deleteByPrimaryKey(Long commId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long commId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

}
