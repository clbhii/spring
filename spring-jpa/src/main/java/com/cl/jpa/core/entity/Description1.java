package com.cl.jpa.core.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_description1")
@Data
public class Description1 implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY) //IDENTITY 自增
    private Integer id;

    private String description;
}