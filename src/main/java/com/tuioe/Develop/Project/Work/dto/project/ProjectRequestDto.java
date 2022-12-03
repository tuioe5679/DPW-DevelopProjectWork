package com.tuioe.Develop.Project.Work.dto.project;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectRequestDto {

    private String title;

    private String content;

    private String image;

    private String startDate;

    private String endDate;

    private String giturl;

    private User user;

    @Builder
    public ProjectRequestDto(String title, String content, String image, String startDate, String endDate, String giturl, User user) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.giturl = giturl;
        this.user = user;
    }

    public Project toEntity(User user){
        return Project
                .builder()
                .title(title)
                .content(content)
                .image(image)
                .startDate(startDate)
                .endDate(endDate)
                .giturl(giturl)
                .user(user)
                .build();
    }
}
