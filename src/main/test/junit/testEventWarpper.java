package junit;

import cap.mvc.model.wrapper.EventWrapper;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testEventWarpper {
    private EventWrapper wrapper;

    @Before
    public void init() {
        wrapper = new EventWrapper();

    }


    @Test
    public void simpleTest() {
        String str = 2018+"年"+9+"月" +1+"日" ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        try {
            Date date = sdf.parse(str);
            System.out.println(sdf.format(date));
            wrapper.setDt(date.getTime());
            System.out.println(wrapper.getFormatDt());
     //       Assert.assertSame(sdf.format(date),wrapper.getFormatDt());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
