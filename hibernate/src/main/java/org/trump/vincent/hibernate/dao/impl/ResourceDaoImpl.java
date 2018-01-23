package org.trump.vincent.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.trump.vincent.hibernate.core.SingletonSessionFactory;
import org.trump.vincent.hibernate.dao.ResourceDao;
import org.trump.vincent.hibernate.domain.Resource;

import java.util.List;

/**
 * Created by Vincent on 2018/1/23 0023.
 */
public class ResourceDaoImpl implements ResourceDao {

    public Resource findById(String id) {
        Session session = SingletonSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "FROM org.trump.vincent.hibernate.domain.Resource WHERE ID =:resourceId";
        Query<Resource> resourceQuery = session.createQuery(hql,Resource.class);
        resourceQuery.setString("resourceId",id);
        Resource resource = resourceQuery.getSingleResult();

        session.getTransaction().commit();
        return resource;
    }

    public List<Resource> loadByName(String name) {
        Session session = SingletonSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();

        String hql = "FROM org.trump.vincent.hibernate.domain.Resource WHERE ID LIKE :resourceName";
        Query<Resource> resourceQuery = session.createQuery(hql);
        resourceQuery.setString("resourceName",name);
        List<Resource> resourceList = resourceQuery.list();
        return resourceList;
    }
}
