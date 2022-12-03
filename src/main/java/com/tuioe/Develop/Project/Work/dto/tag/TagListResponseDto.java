package com.tuioe.Develop.Project.Work.dto.tag;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.tag.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TagListResponseDto {

    private Long id;

    private String tag;

    private Project project;

    @Builder
    public TagListResponseDto(Long id, String tag, Project project) {
        this.id = id;
        this.tag = tag;
        this.project = project;
    }

    public TagListResponseDto createTagListDto(Tag tag){
        return TagListResponseDto
                .builder()
                .tag(tag.getTag())
                .project(tag.getProject())
                .build();
    }
}
