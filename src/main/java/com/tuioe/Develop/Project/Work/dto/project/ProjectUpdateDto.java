package com.tuioe.Develop.Project.Work.dto.project;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectUpdateDto {

    private String title;

    private String content;

    private String image;

    private String startDate;

    private String endDate;

    private String giturl;

    @Builder
    public ProjectUpdateDto(String title, String content, String image, String startDate, String endDate, String giturl) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.giturl = giturl;
    }
}
