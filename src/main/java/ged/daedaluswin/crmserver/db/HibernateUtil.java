package ged.daedaluswin.crmserver.db;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;

import java.util.*;

/**
 * Needs refactoring!!
 *
 * Created by Romanos Trechlis on 1/4/2015.
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                //configuration.configure("ged/daedaluswin/crmserver/db/hibernate.cfg.xml");
                configuration.configure();
                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (HibernateException e) {
                throw e;
            }
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void saveOrUpdate(Object obj) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(obj);
        transaction.commit();
    }

    public static List executeSelect(String sql) {
        Session session = getSession();
        Query query = session.createQuery(sql);
        List results = query.list();
        if (session != null)session.close();
        return results;
    }

    /**
     * Method constructs an sql query from parameters.
     *
     * @param select
     * @param from
     * @param joins
     * @param where
     * @param groupBy
     * @param having
     * @param orderBy
     * @return List table
     */
    public static List retrieveList(String select, String from, String joins, String where, String groupBy, String having, String orderBy) {
        String key;
        StringBuilder hql = new StringBuilder();
        if (select != null) hql.append(select);
        if (from != null) hql.append(" " + from);
        if (joins != null) hql.append(" " + joins);
        if (where != null) hql.append(" " + where);
        if (groupBy != null) hql.append(" " + groupBy);
        if (having != null) hql.append(" " + having);
        if (orderBy != null) hql.append(" " + orderBy);

        Session session = getSession();
        Query query = session.createQuery(hql.toString());
        List results = query.list();
        if (session != null)session.close();
        return results;
    }

    public static List retrieveList(String from) {
        return retrieveList(null, from, null, null, null, null, null);
    }

    public static List retrieveList(String select, String from, String where) {
        return retrieveList(select, from, where, null, null, null, null);
    }

    public static List retrieveList(String select, String from, String where, String groupBy) {
        return retrieveList(select, from, where, groupBy, null, null, null);
    }

    public static List getListOfData(Class classBean, String key, String value) {
        List result;
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(classBean);
        if (key != null) {
            criteria.add(Restrictions.ilike(key, value));

        }
        result = criteria.list();
        tx.commit();
        session.close();
        return result;
    }
}
