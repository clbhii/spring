package com.cl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cl.model.UserDO;

import java.util.List;

public interface UserService extends IService<UserDO> {

    UserDO selectByUserNameAndPassword(String userName, String password);

    IPage<UserDO> selectPageVo(Page<UserDO> page);

    void insertBatch(List<UserDO> userDOList);
}
