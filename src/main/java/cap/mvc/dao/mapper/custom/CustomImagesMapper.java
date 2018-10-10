package cap.mvc.dao.mapper.custom;

import cap.mvc.model.Images;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface CustomImagesMapper  {
    List<Images> findAll();
}