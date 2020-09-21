package com.cl.jpa.core.dao;

import com.cl.jpa.core.entity.User;
import com.cl.jpa.core.service.dto.UserDTO;
import com.cl.jpa.core.service.dto.UserInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    @Query(value = "from User") //HQL
//    @Query(value = "select * from tb_user",nativeQuery = true)//原生SQL
    List<User> getAllUser();

    User getByUsername(String username);


    List<UserInterface> findAllById(Integer id);

    UserDTO getById(Integer id);

}