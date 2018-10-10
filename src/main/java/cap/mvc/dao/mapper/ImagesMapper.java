package cap.mvc.dao.mapper;

import cap.mvc.dao.mapper.custom.CustomImagesMapper;
import cap.mvc.model.Images;
import org.springframework.stereotype.Repository;

@Repository

public interface ImagesMapper extends CustomImagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Images record);

    int insertSelective(Images record);

    Images selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Images record);

    int updateByPrimaryKey(Images record);

}