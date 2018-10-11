package cap.mvc.model.wrapper;

import cap.mvc.model.Event;
import cap.util.FileName;

import java.util.Date;

public class EventWrapper extends Event{

    public String getFormatDt() {
        return new Date(getDt()).toString();
    }

    public String[] getDivPath() {
        return FileName.divStr(getImgagesPath());
    }
}
