package com.tuioe.Develop.Project.Work.dto.user;

import com.tuioe.Develop.Project.Work.auth.dto.SessionUser;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginUserResponseDto {

    private String name;
    private String picture;

    @Builder
    public LoginUserResponseDto(String name, String picture) {
        this.name = name;
        this.picture = picture;
    }

    public LoginUserResponseDto createLoginUserDto(SessionUser sessionUser){
        return LoginUserResponseDto
                .builder()
                .name(sessionUser.getName())
                .picture(sessionUser.getPicture())
                .build();
    }
}
