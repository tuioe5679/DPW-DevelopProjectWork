package com.tuioe.Develop.Project.Work.dto.comment;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tuioe.Develop.Project.Work.domain.comment.Comment;
import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentListResponseDto {

    private Long id;

    private String comment;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createDate;

    private Project project;

    private User user;

    @Builder
    public CommentListResponseDto(Long id, String comment, LocalDateTime createDate, Project project, User user) {
        this.id = id;
        this.comment = comment;
        this.createDate = createDate;
        this.project = project;
        this.user = user;
    }

    public CommentListResponseDto createCommentListDto(Comment comment){
        return CommentListResponseDto
                .builder()
                .comment(comment.getComment())
                .createDate(comment.getCreateDate())
                .project(comment.getProject())
                .user(comment.getUser())
                .build();
    }
}
