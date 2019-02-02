package cap.listener;

import cap.mvc.service.CounterService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CounterListener implements HttpSessionListener , ServletRequestListener {


    private CounterService counterService;
    private HttpServletRequest request;


    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
       counterService = getCounterService(httpSessionEvent.getSession().getServletContext());
       if(counterService !=null) {
           counterService.increase();
       }
        String logMsg=httpSessionEvent.getSession().getId()

                +"'  '"+request.getRemoteAddr()

                +":"+request.getRemotePort();
       System.out.println(logMsg);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }


    private CounterService getCounterService(ServletContext servletContext){
        if(counterService == null) {
            ApplicationContext application = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            counterService = application.getBean(CounterService.class);
        }
        return counterService;
    }


    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        request=(HttpServletRequest)servletRequestEvent.getServletRequest();
    }
}
