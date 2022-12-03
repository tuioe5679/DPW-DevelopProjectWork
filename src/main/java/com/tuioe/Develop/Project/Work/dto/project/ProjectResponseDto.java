package com.tuioe.Develop.Project.Work.dto.project;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.tag.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProjectResponseDto {

    private Long id;

    private String title;

    private String content;

    private String image;

    private String startDate;

    private String endDate;

    private String giturl;

    private Tag tag;

    @Builder
    public ProjectResponseDto(Long id, String title, String content, String image, String startDate, String endDate, String giturl, Tag tag) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.giturl = giturl;
        this.tag = tag;
    }

    public ProjectResponseDto createProDto(Project project){
        return ProjectResponseDto
                .builder()
                .title(project.getTitle())
                .content(project.getContent())
                .image(project.getImage())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .giturl(project.getGiturl())
                .tag(project.getTag())
                .build();
    }
}
