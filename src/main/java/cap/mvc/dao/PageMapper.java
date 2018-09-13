package cap.mvc.dao;

import cap.mvc.model.Page;

public interface PageMapper {
    int deleteByPrimaryKey(Long pageId);

    int insert(Page record);

    int insertSelective(Page record);

    Page selectByPrimaryKey(Long pageId);

    int updateByPrimaryKeySelective(Page record);

    int updateByPrimaryKey(Page record);
}