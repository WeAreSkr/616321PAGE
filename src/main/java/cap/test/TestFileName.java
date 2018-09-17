package cap.test;
import cap.util.FileName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFileName {
    @Test
    public void testgetSuitableName() {
        System.out.println(FileName.getRandomString(12));
        assertEquals(FileName.getRandomString(10).length(),10);
    }

    @Test
    public void testMgStr() {
        System.out.println(FileName.mgStr(new String[]{"1","2","3","mgstr"}));
        assertEquals(FileName.mgStr(new String[]{"1","2","3","mgstr"}),"1|2|3|mgstr");
        assertEquals(FileName.mgStr(new String[]{"a.jpg","b.jpg","m.jpg","boy.jpg"}),"a.jpg|b.jpg|m.jpg|boy.jpg");
    }

    @Test
    void testDivStr() {

        System.out.println(Arrays.asList(FileName.divStr("1|2|3|mgstr")));
        assertEquals(Arrays.asList(FileName.divStr("1|2|3|mgstr")),Arrays.asList(new String[]{"1","2","3","mgstr"}));
    }

}
