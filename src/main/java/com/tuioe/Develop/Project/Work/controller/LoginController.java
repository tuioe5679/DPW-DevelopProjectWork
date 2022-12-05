package com.tuioe.Develop.Project.Work.controller;

import com.tuioe.Develop.Project.Work.dto.user.LoginUserResponseDto;
import com.tuioe.Develop.Project.Work.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "Login Controller",tags = "User")
public class LoginController {
    
    private final UserService userService;

    @ApiOperation(value = "로그인 유저 조회",notes = "로그인한 유저의 정보를 조회합니다")
    @GetMapping("/login")
    public ResponseEntity<LoginUserResponseDto> loginUser(){
        return new ResponseEntity<>(userService.findLoginUser(), HttpStatus.OK);
    }
    
}
