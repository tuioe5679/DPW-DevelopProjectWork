package com.tuioe.Develop.Project.Work.dto.tag;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.tag.Tag;
import lombok.Getter;

@Getter
public class TagListResponseDto {

    private Long id;

    private String tag;

    private Project project;

    public TagListResponseDto(Tag tag) {
        this.id = tag.getId();
        this.tag = tag.getTag();
        this.project = tag.getProject();
    }
}
