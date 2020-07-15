package com.cl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cl.model.UserDO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * by cl at 2020/6/25 0025
 */
@Repository
public interface UserDao extends BaseMapper<UserDO> {

    UserDO selectByUserNameAndPassword(Map<String, Object> map);

    IPage<UserDO> selectPageVo(Page<UserDO> page);

    void insertBatch(List<UserDO> userDOList);
}
