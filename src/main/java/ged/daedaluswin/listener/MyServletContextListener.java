package ged.daedaluswin.listener;


import com.sun.xml.ws.transport.http.servlet.WSServletContextListener;
import ged.daedaluswin.db.ConnBroker;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Necessary for diminishing ConnBroker's instantiation time.
 *
 * <p>Most of it, it is copied from actual WSServletContextListener.</p>
 * Created by Romanos Trechlis on 21/3/2015.
 */
public final class MyServletContextListener implements ServletContextListener {
    WSServletContextListener servletContextListener;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextListener = new WSServletContextListener();
        servletContextListener.contextInitialized(servletContextEvent);

        ConnBroker.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        servletContextListener.contextDestroyed(servletContextEvent);
    }
}