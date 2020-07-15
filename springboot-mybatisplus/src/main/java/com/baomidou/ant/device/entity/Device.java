package com.baomidou.ant.device.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备表
 * </p>
 *
 * @author jobob
 * @since 2020-06-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Device implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 设备类型 1：智能电灯，2：智能空调
     */
    private Integer devType;

    /**
     * 设备编号
     */
    private String devNo;

    /**
     * 设备名称
     */
    private String devName;

    /**
     * 设备状态 0：离线，1：在线
     */
    private Integer devStatus;

    /**
     * 设备图片
     */
    private String devImg;

    /**
     * 拥有者id
     */
    private Long ownerId;

    /**
     * 创建时间
     */
    private LocalDateTime dateCreate;

    /**
     * 修改时间
     */
    private LocalDateTime dateUpdate;


}
