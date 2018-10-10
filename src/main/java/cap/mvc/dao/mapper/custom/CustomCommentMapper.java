package cap.mvc.dao.mapper.custom;

import cap.mvc.model.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CustomCommentMapper {
    List<Comment> selectByPage(@Param("pageId") Long pageId);
}
