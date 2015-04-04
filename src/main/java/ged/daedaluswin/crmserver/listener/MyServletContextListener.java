package ged.daedaluswin.crmserver.listener;


import com.sun.xml.ws.transport.http.servlet.WSServletContextListener;
import ged.daedaluswin.crmserver.db.ConnBroker;
import ged.daedaluswin.crmserver.db.HibernateUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Necessary for diminishing ConnBroker's instantiation time.
 *
 * <p>Most of it, it is copied from actual WSServletContextListener.</p>
 * Created by Romanos Trechlis on 21/3/2015.
 */
public final class MyServletContextListener implements ServletContextListener {
    WSServletContextListener servletContextListener = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextListener = new WSServletContextListener();
        servletContextListener.contextInitialized(servletContextEvent);

        HibernateUtil.getSession();
        ConnBroker.getInstance();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        if (HibernateUtil.getSession() != null) HibernateUtil.getSession().close();
        if (HibernateUtil.getSessionFactory()!= null) HibernateUtil.getSessionFactory().close();
        servletContextListener.contextDestroyed(servletContextEvent);
    }
}