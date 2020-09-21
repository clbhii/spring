package com.cl.jpa.core.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Copyright © 2018年 chilunyc.com All rights reserved.
 */

public interface UserInterface {


    @Value("#{target.username + ' ' + target.password}")
    String getName();

}
