package com.tuioe.Develop.Project.Work.service;

import com.tuioe.Develop.Project.Work.auth.CustomOAuth2UserService;
import com.tuioe.Develop.Project.Work.auth.dto.SessionUser;
import com.tuioe.Develop.Project.Work.domain.user.User;
import com.tuioe.Develop.Project.Work.domain.user.UserRepository;
import com.tuioe.Develop.Project.Work.dto.user.LoginUserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Transactional
    public LoginUserResponseDto findLoginUser(){

        SessionUser sessionUser = (SessionUser)httpSession.getAttribute("user");
        if(sessionUser != null){
            User user = userRepository.findByEmail(sessionUser.getEmail()).get();
            return new LoginUserResponseDto().createLoginUserDto(sessionUser,user);
        }
        else {
            return null;
        }
    }
}
