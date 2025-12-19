package com.example.demo.security;

import com.example.demo.domain.UserVO;
import com.example.demo.repository.UserDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@Slf4j
public class CustomUserService implements UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // username 주고 해당 유저의 객체를 리턴 받기

        UserVO userVO = userDAO.getUser(username);

        // 추가
        if (userVO == null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }

        userVO.setAuthList(userDAO.getUserAuth(username));
        log.info(">>> loginUser>> {}", userVO);


        return new AuthUser(userVO);
    }
}
