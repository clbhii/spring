package com.cl.jpa.core.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

/**
 * by cl at 2020/8/25 0025
 */
@Data
public class BaseDO implements Serializable {

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建用户
     */
    @Column(length = 64)
    private String createBy;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 修改用户
     */
    @Column(length = 64)
    private String updateBy;
    /**
     * 删除状态(0-正常,1-已删除)
     */
    private Integer delFlag;
}
