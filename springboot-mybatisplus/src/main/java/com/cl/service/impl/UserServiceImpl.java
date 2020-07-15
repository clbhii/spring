package com.cl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cl.dao.UserDao;
import com.cl.model.UserDO;
import com.cl.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * by cl at 2020/6/25 0025
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserDO> implements UserService {


    @Override
    public UserDO selectByUserNameAndPassword(String userName, String password) {
        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        map.put("password", password);
        return baseMapper.selectByUserNameAndPassword(map);
    }

    @Override
    public IPage<UserDO> selectPageVo(Page<UserDO> page) {
        return baseMapper.selectPageVo(page);
    }

    @Override
    public void insertBatch(List<UserDO> userDOList) {
        baseMapper.insertBatch(userDOList);
    }
}
