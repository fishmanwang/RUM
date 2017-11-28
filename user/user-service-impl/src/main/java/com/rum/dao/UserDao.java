package com.rum.dao;

import com.mybatis.domain.PageBounds;
import com.rum.model.User;
import com.rum.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithPageBounds(UserExample example, PageBounds pageBounds);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}