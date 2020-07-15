package com.cl.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("user")
@Data
public class UserDO {
    /**
     * 
     */
    //@TableId(type= IdType.AUTO) //全局配置global-config.db-config.id-type=auto
    private Long id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 创建时间
     */
    private Date dateCreate;

    /**
     * 修改时间
     */
    private Date dateUpdate;


}