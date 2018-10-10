package cap.mvc.dao.mapper.custom;

import cap.mvc.model.association.PageAs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomPageMapper{
    PageAs asSelectById(@Param("pageId") Long pageId);
}