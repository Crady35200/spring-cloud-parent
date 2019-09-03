package com.crady.user.mapper;

import com.crady.user.po.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author :Crady
 * date :2019/6/19 16:18
 * desc :
 **/
@Mapper
public interface UserMapper {

    @Select("select * from t_user")
    List<User> getAllUsers();

    @Select("select * from t_user where id = #{id}")
    User getUserById(Integer id);

    @Insert("insert into t_user(name,password,age,sex) values (#{name},#{password},#{age},#{sex})")
    int insertUser(User user);

}
