package com.tuioe.Develop.Project.Work.dto.tag;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TagUpdateDto {

    private String tag;

    @Builder
    public TagUpdateDto(String tag) {
        this.tag = tag;
    }
}
