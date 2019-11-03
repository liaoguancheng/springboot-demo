package com.zhss.springboot.mapper;

import com.zhss.springboot.domain.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    @ Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    List<User> listUsers();
    
    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(@Param("id") Long id);
    
    @Insert("INSERT INTO user(name, age) VALUES(#{name}, #{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long saveUser(User user);
    
    @Update("UPDATE user SET name=#{name}, age=#{age} WHERE id=#{id}")
    long updateUser(User user);
    
    @Delete("DELETE FROM user WHERE id=#{id}")
    long removeUser(@Param("id") Long id);
    
}
