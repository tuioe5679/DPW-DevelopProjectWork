package com.tuioe.Develop.Project.Work.domain.project;

import com.tuioe.Develop.Project.Work.domain.user.User;
import com.tuioe.Develop.Project.Work.dto.project.ProjectUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    @ManyToOne(fetch = FetchType.EAGER)// 지연 로딩 (빠른 속도 처리가능)
    @JoinColumn(name = "user_id")
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
        this.endDate = dto.getStartDate();
        return this;
    }

}
