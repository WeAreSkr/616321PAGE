package cap.mvc.dao.mapper;

import cap.mvc.model.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface PageMapper {
    int deleteByPrimaryKey(Long pageId);

    int insert(Page record);

    int insertSelective(Page record);

    Page selectByPrimaryKey(Long pageId);

    int updateByPrimaryKeySelective(Page record);

    int updateByPrimaryKey(Page record);
}