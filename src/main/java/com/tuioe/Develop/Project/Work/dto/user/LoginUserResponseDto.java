package com.tuioe.Develop.Project.Work.dto.user;

import com.tuioe.Develop.Project.Work.auth.dto.SessionUser;
import com.tuioe.Develop.Project.Work.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginUserResponseDto {

    private String name;
    private String picture;
    private int jewel;

    @Builder
    public LoginUserResponseDto(String name, String picture,int jewel) {
        this.name = name;
        this.picture = picture;
        this.jewel = jewel;
    }

    public LoginUserResponseDto createLoginUserDto(SessionUser sessionUser, User user){
        return LoginUserResponseDto
                .builder()
                .name(sessionUser.getName())
                .picture(sessionUser.getPicture())
                .jewel(user.getJewel())
                .build();
    }
}
