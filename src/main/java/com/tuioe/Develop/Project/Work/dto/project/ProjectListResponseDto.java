package com.tuioe.Develop.Project.Work.dto.project;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.tag.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectListResponseDto {
    private Long id;

    private String title;

    private String content;

    private String image;

    private Tag tag;

    @Builder
    public ProjectListResponseDto(Long id, String title, String content, String image, Tag tag) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.tag = tag;
    }

    public ProjectListResponseDto createProListDto(Project project){
        return ProjectListResponseDto
                .builder()
                .title(project.getTitle())
                .content(project.getContent())
                .image(project.getImage())
                .tag(project.getTag())
                .build();
    }
}
