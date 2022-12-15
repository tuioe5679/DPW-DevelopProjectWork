package com.tuioe.Develop.Project.Work.domain.project;

import com.tuioe.Develop.Project.Work.domain.developdiary.DevelopDiary;
import com.tuioe.Develop.Project.Work.domain.user.User;
import com.tuioe.Develop.Project.Work.dto.project.ProjectUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = false,length = 5000)
    private String content;

    @Column(length = 200)
    private String image;

    @Column(nullable = false,length = 20)
    private String startDate;

    @Column(nullable = false,length = 20)
    private String endDate;

    @Column(length = 100)
    private String giturl;

    @ManyToOne(fetch = FetchType.EAGER)// User:Project = 1:N 관계
    @JoinColumn(name = "user_id",nullable = false)// user_id로 외래키 지정,널값 허용 X
    @OnDelete(action = OnDeleteAction.CASCADE)//유저 삭제시 연관 프로젝트 삭제
    private User user;


    @Builder
    public Project(Long id, String title, String content, String image, String startDate, String endDate, String giturl,User user) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.giturl = giturl;
        this.user = user;
    }

    public Project update(ProjectUpdateDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.giturl = dto.getGiturl();
        return this;
    }

}
