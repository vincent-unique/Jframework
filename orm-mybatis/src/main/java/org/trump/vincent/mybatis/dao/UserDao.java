package org.trump.vincent.mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.trump.vincent.mybatis.domain.User;

import java.util.List;

public interface UserDao {

    public static final String USER_TABLE = "tb_user";


    @Select("select * from "+USER_TABLE+" where ID = #{id}")
    User selectById(String id);

    @Select("select * from "+USER_TABLE+" where name = #{name}")
    List<User> selectByName(@Param("name") String username);

    @Select("delete from "+USER_TABLE+" where id = #{id}")
    void removeById(String id);

}
