package com.tuioe.Develop.Project.Work.dto.project;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import lombok.Getter;

@Getter
public class ProjectListResponseDto {
    private Long id;

    private String title;

    private String content;

    private String image;

    public ProjectListResponseDto(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.content = project.getContent();
        this.image = project.getImage();
    }
}
