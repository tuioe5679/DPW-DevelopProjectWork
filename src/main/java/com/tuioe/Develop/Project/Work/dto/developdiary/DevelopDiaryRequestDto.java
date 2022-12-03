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

    private Long id;

    @Builder
    public DevelopDiaryRequestDto(String title, String content, LocalDateTime createDate,Long id) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.id = id;
    }

    public DevelopDiary toEntity(Project project){
        return DevelopDiary
                .builder()
                .title(title)
                .content(content)
                .project(project)
                .build();
    }
}
