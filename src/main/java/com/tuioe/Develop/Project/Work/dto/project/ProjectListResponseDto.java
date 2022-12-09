package com.tuioe.Develop.Project.Work.dto.project;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import lombok.Getter;

@Getter
public class ProjectListResponseDto {
    private Long id;

    private String title;

    private String content;

    private String startDate;

    private String image;

    private String username;

    public ProjectListResponseDto(Project project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.content = project.getContent();
        this.startDate = project.getStartDate();
        this.image = project.getImage();
        this.username = project.getUser().getNickname();
    }
}
