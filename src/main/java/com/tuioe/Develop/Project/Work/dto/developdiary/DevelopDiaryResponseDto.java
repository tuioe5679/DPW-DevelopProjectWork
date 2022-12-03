package com.tuioe.Develop.Project.Work.dto.developdiary;

import com.tuioe.Develop.Project.Work.domain.developdiary.DevelopDiary;
import com.tuioe.Develop.Project.Work.domain.project.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class DevelopDiaryResponseDto {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime createDate;

    private Project project;

    @Builder
    public DevelopDiaryResponseDto(Long id, String title, String content, LocalDateTime createDate, Project project) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.project = project;
    }

    public DevelopDiaryResponseDto createDiaryDto(DevelopDiary developDiary){
        return DevelopDiaryResponseDto
                .builder()
                .id(developDiary.getId())
                .title(developDiary.getTitle())
                .content(developDiary.getContent())
                .createDate(developDiary.getCreateDate())
                .project(developDiary.getProject())
                .build();
    }
}
