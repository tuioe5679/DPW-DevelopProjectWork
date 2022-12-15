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
    private String giturl;

    @Builder
    public ProjectUpdateDto(String title, String content, String image, String giturl) {
        this.title = title;
        this.content = content;
        this.image = image;
        this.giturl = giturl;
    }
}
