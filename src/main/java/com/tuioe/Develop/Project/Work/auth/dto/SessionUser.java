package com.tuioe.Develop.Project.Work.auth.dto;

import com.tuioe.Develop.Project.Work.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getNickname();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
