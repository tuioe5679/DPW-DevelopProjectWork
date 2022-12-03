package com.tuioe.Develop.Project.Work.dto.developdiary;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DevelopDiaryUpdateDto {

    private String title;

    private String content;

    @Builder
    public DevelopDiaryUpdateDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
