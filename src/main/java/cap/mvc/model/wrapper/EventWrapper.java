package cap.mvc.model.wrapper;

import cap.mvc.model.Event;
import cap.util.FileName;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EventWrapper extends Event{

    public String getFormatDt() {

        SimpleDateFormat formator = new SimpleDateFormat("yyyy年mm月dd日");


        return  formator.format(new Date(getDt()));
    }

    public String[] getDivPath() {
        return FileName.divStr(getImgagesPath());
    }
}
