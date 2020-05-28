package com.cl.springboot2.dao;


import com.cl.springboot2.model.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserDAO{

    int insert(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    int updateByPrimaryKey(UserDO record);

    int deleteByPrimaryKey(Long id);

    List<UserDO> selectList(Map<String, Object> map);

    int countList(Map<String, Object> map);

    UserDO selectByUserNameAndPassword(Map<String, Object> map);

}