package cap.mvc.dao.mapper;

import cap.mvc.model.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Long commId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long commId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}