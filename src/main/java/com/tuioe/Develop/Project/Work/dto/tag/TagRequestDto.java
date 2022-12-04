package com.tuioe.Develop.Project.Work.dto.tag;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.tag.Tag;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TagRequestDto {

    private String tag;
    private Long id;

    @Builder
    public TagRequestDto(String tag, Long id) {
        this.tag = tag;
        this.id = id;
    }

    public Tag toEntity(Project project){
        return Tag
                .builder()
                .tag(tag)
                .project(project)
                .build();
    }
}
