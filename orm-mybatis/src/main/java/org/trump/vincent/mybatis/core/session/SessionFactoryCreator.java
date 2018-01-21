package org.trump.vincent.mybatis.core.session;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SessionFactoryCreator {

    private static volatile SqlSessionFactory sqlSessionFactory;
    private static Object mutex = new Object();

    public static final String DEFAULT_CONFIGURATION = "mybatis-config.xml";

    private SessionFactoryCreator() {
        InputStream configStream = null;
        try {
            configStream = Resources.getResourceAsStream(DEFAULT_CONFIGURATION);
            SessionFactoryCreator.sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(configStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        if(sqlSessionFactory==null){
            synchronized (mutex){
                if(sqlSessionFactory == null){
                    new SessionFactoryCreator();
                }
            }
        }
        return sqlSessionFactory;
    }
}
