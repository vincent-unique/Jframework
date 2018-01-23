package org.trump.vincent.hibernate.core;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.trump.vincent.hibernate.domain.Resource;

import java.io.File;
import java.net.URL;

/**
 * Created by Vincent on 2018/1/23 0023.
 */
public class DynamicSessionFactory {

    private static Object mutex = new Object();

    public static SessionFactory getSessionFactory(String configuration){
        SessionFactory sessionFactory = null;
        synchronized (mutex){
             sessionFactory = new Configuration().configure(configuration).buildSessionFactory();
       }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(File configuration){
        SessionFactory sessionFactory = null;
        synchronized (mutex){
            sessionFactory = new Configuration().configure(configuration).buildSessionFactory();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory(URL configuration){
        SessionFactory sessionFactory = null;
        synchronized (mutex){
            sessionFactory = new Configuration().configure(configuration).buildSessionFactory();
        }
        return sessionFactory;
    }

}
