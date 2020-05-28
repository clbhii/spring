package com.cl.springboot2.service;


import com.cl.springboot2.common.Page;
import com.cl.springboot2.model.UserDO;

public interface IUserService {

    int insert(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKey(UserDO record);

    int deleteByPrimaryKey(Long id);

    Page<UserDO> page(String userName, Integer curPage, Integer pageSize);

    UserDO selectByUserNameAndPassword(String userName, String password);
}
