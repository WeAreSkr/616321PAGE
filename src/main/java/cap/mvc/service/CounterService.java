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
        System.out.println("get tcount:"+tCount);
       return tCount+"";
    }

    public void increase() {

        synchronized (tCount) {
            if(tCount == -1) {
                tCount = countDao.getCount();
            }
            tCount ++;
            System.out.println("increase tcount:"+tCount);
            if(tCount > 0) {
                countDao.setCount(tCount);
            }
        }
    }

    public CountDao getCountDao() {
        return countDao;
    }

    public void setCountDao(CountDao countDao) {
        this.countDao = countDao;
    }
}
