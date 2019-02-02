package cap.mvc.service;

import cap.mvc.dao.CountDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CounterService {

    @Resource
    private CountDao countDao;

    private Integer tCount = -1;

    public CounterService() {
        System.out.println("*********************CounterService***************************");
    }

    public String getCount() {
        if(tCount == -1) {
            return countDao.getCount()+"";
        }
       return tCount+"";
    }

    public void increase() {
        synchronized (tCount) {
            if(tCount == -1) {
                tCount = countDao.getCount();
            }

            tCount ++;
            if(tCount % 5 == 0) {
                countDao.setCount(tCount);
            }
        }
    }

}
