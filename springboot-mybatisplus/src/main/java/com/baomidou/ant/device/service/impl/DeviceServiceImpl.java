package com.baomidou.ant.device.service.impl;

import com.baomidou.ant.device.entity.Device;
import com.baomidou.ant.device.mapper.DeviceMapper;
import com.baomidou.ant.device.service.IDeviceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备表 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-06-27
 */
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {

}
