package com.tuioe.Develop.Project.Work.dto.developdiary;

import com.tuioe.Develop.Project.Work.domain.developdiary.DevelopDiary;
import com.tuioe.Develop.Project.Work.domain.project.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class DevelopDiaryRequestDto {

    private String title;

    private String content;

    private LocalDateTime createDate;

    private Project project;

    @Builder
    public DevelopDiaryRequestDto(String title, String content, LocalDateTime createDate, Project project) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.project = project;
    }

    public DevelopDiary toEntity(){
        return DevelopDiary
                .builder()
                .title(title)
                .content(content)
                .project(project)
                .build();
    }
}
