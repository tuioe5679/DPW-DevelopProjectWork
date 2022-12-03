package com.tuioe.Develop.Project.Work.dto.project;

import com.tuioe.Develop.Project.Work.domain.project.Project;
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

    @Builder
    public ProjectRequestDto(String title, String content, String image, String startDate, String endDate, String giturl) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.giturl = giturl;
    }

    public Project toEntity(){
        return Project
                .builder()
                .title(title)
                .content(content)
                .image(image)
                .startDate(startDate)
                .endDate(endDate)
                .giturl(giturl)
                .build();
    }
}
