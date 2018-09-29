package cap.test;

import cap.util.SavaHtml;
import org.junit.jupiter.api.Test;

public class TestSavaHtml {

    @Test
    public void testSava() {
        SavaHtml.savaHtmlorMd("163796.html","<p>hello,world</p>");
    }

    @Test
    public void testRead() {
        System.out.println("Content:" + SavaHtml.readHtmlorMd("163796.html"));
    }

}
