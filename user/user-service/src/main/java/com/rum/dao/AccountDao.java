package com.rum.dao;

import com.mybatis.domain.PageBounds;
import com.rum.model.Account;
import com.rum.model.AccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountDao {
    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExampleWithPageBounds(AccountExample example, PageBounds pageBounds);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}