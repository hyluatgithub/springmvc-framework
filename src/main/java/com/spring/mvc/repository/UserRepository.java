package com.spring.mvc.repository;

import com.spring.mvc.model.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus1 on 2016/3/21.
 */
public interface UserRepository extends JpaRepository<UsersModel, Integer> {

    @Modifying  //说明该方法是修改操作
    @Transactional //说明该方法是事务性操作
    //定义查询
    @Query("update UsersModel us set us.nickname=:qNickname,us.password=:qPassword where us.id=:qId")
    public void updateUser(@Param("qNickname") String nickname,@Param("qPassword") String password,@Param("qId") Integer id);

}
