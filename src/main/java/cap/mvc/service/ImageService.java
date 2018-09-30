package cap.mvc.service;

import cap.mvc.dao.mapper.ImagesMapper;
import cap.mvc.model.Images;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ImageService {
    @Resource
    private ImagesMapper imagesMapper;

    public List<Images> findAll(){
        return  imagesMapper.findAll();
    }

    public int addImage(Images images) {
       return imagesMapper.insert(images);
    }
}
