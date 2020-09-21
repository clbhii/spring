package com.cl.jpa.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_description2")
@Data
public class Description2 implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //IDENTITY 自增
    private Integer id;

    private String description;
}