package cap.mvc.dao.mapper;

import cap.mvc.model.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface CommentMapper {
    int deleteByPrimaryKey(Long commId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long commId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByPage(@Param("pageId") Long pageId);}
