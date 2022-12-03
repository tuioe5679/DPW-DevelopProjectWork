package com.tuioe.Develop.Project.Work.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 15)
    private String nickname;

    @Column(nullable = false,length = 50)
    private String email;

    @Column(length = 100)
    private String picture;

    @Column(nullable = false)
    private int jewel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(Long id, String nickname, String email, String picture, int jewel, Role role) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.picture = picture;
        this.jewel = jewel;
        this.role = role;
    }

    public User update(String nickname,String picture){
        this.nickname = nickname;
        this.picture = picture;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}