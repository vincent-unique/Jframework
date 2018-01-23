package org.trump.vincent.hibernate.core;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Vincent on 2018/1/23 0023.
 */
public class SingletonSessionFactory {

    private static class Inner{
        private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return Inner.sessionFactory;
    }
}
