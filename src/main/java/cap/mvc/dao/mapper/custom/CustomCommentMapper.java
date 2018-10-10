package cap.mvc.dao.mapper.custom;

import cap.mvc.model.association.CommentsAs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomCommentMapper {
    List<CommentsAs> selectByPage(@Param("pageId") Long pageId);
}
