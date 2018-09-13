package cap.mvc.dao;

import cap.mvc.model.Images;

public interface ImagesMapper {
    int deleteByPrimaryKey(String picPath);

    int insert(Images record);

    int insertSelective(Images record);

    Images selectByPrimaryKey(String picPath);

    int updateByPrimaryKeySelective(Images record);

    int updateByPrimaryKey(Images record);
}