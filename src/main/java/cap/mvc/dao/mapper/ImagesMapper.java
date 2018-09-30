package cap.mvc.dao.mapper;

import cap.mvc.model.Images;

import java.util.List;


public interface ImagesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Images record);

    int insertSelective(Images record);

    Images selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Images record);

    int updateByPrimaryKey(Images record);

    List<Images> findAll();
}