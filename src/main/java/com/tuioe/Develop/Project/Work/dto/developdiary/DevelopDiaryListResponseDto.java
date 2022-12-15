package com.tuioe.Develop.Project.Work.dto.developdiary;

import com.tuioe.Develop.Project.Work.domain.developdiary.DevelopDiary;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DevelopDiaryListResponseDto {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime createDate;

    public DevelopDiaryListResponseDto(DevelopDiary developDiary) {
        this.id = developDiary.getId();
        this.title = developDiary.getTitle();
        this.content = developDiary.getContent();
        this.createDate = developDiary.getCreateDate();
    }
}
