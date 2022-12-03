package com.tuioe.Develop.Project.Work.dto.comment;

import com.tuioe.Develop.Project.Work.domain.comment.Comment;
import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentRequestDto {

    private Long id;

    private String comment;

    private LocalDateTime createDate;

    private Project project;

    private User user;

    @Builder
    public CommentRequestDto(Long id, String comment, LocalDateTime createDate, Project project, User user) {
        this.id = id;
        this.comment = comment;
        this.createDate = createDate;
        this.project = project;
        this.user = user;
    }

    public Comment toEntity(){
        return Comment
                .builder()
                .comment(comment)
                .project(project)
                .user(user)
                .build();
    }
}
