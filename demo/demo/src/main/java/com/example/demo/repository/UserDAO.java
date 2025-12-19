package com.example.demo.repository;

import com.example.demo.domain.AuthVO;
import com.example.demo.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {

    void insert(UserVO userVO);

    void authInsert(String email);

    UserVO getUser(String username);

    List<AuthVO> getUserAuth(String username);

    void remove(String name);

    void modify(UserVO userVO);

    void authDelete(String name);

    void modifyNoPwd(UserVO userVO);

    List<UserVO> getList();
}
