package com.tuioe.Develop.Project.Work.service;

import com.tuioe.Develop.Project.Work.auth.CustomOAuth2UserService;
import com.tuioe.Develop.Project.Work.auth.dto.SessionUser;
import com.tuioe.Develop.Project.Work.dto.user.LoginUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final HttpSession httpSession;

    @Transactional
    public LoginUserResponseDto findLoginUser(){

        SessionUser sessionUser = (SessionUser)httpSession.getAttribute("user");
        System.out.println(sessionUser);
        if(sessionUser != null){
            return new LoginUserResponseDto().createLoginUserDto(sessionUser);
        }
        else {
            return null;
        }
    }
}
