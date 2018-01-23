package org.trump.vincent.hibernate.dao;

import org.trump.vincent.hibernate.domain.Resource;

import java.util.List;

/**
 * Created by Vincent on 2018/1/23 0023.
 */
public interface ResourceDao {

    Resource findById(String id);

    List<Resource> loadByName(String name);
}
