package com.cl.jpa.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
@ApiModel("User(用户结果)")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //IDENTITY 自增
    private Integer id;

    @Column(name = "username")//命名相同或驼峰标识（与数据库下划线映射）可以不用写
    private String username;
    @ApiModelProperty("用户密码")
    private String password;

    private Date created;

    private String createdUserId;

    @OneToOne( fetch=FetchType.LAZY)
    @JoinColumn(name = "description_id",insertable = false, updatable = false)
//    @NotFound(action= NotFoundAction.IGNORE)
    //用户描述信息
    private Description description;

    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Description1> descriptionList;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name = "user_description2", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "description2_id", referencedColumnName = "id"))
    private List<Description2> description2List;

    @Column(name = "description3_id")
    private Integer description3Id;
    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "description3_id",insertable = false, updatable = false)
    private Description3 description3;
}