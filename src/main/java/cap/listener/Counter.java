package cap.listener;

import cap.mvc.service.CounterService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Counter implements HttpSessionListener {


    CounterService counterService;




    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
       CounterService tCounterService = getCounterService(httpSessionEvent.getSession().getServletContext());
       tCounterService.increase();
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

    }


    private CounterService getCounterService(ServletContext servletContext){
        if(counterService == null) {
            ApplicationContext application = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            counterService = (CounterService) application.getBean("counterService");
        }
        return counterService;
    }

}
