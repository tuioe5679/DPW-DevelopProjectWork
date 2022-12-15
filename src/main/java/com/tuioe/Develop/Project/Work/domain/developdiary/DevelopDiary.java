package com.tuioe.Develop.Project.Work.domain.developdiary;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "DevelopDiary")
@EntityListeners(AuditingEntityListener.class)// 엔티티 리스너를 적용 (Auditing 기능을 포함시킨다) @CreateDate 기능 사용시 필요
public class DevelopDiary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = false,length = 2000)
    private String content;

    @CreatedDate// 생성 날짜 자동 생성
    @Column(nullable = false)
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.EAGER)// Pro:Develop = 1:N 관계
    @JoinColumn(name = "pro_id",nullable = false)// pro_id로 외래키로 지정,널값 허용 X
    @OnDelete(action = OnDeleteAction.CASCADE)// Project 삭제시 연관된 Develop 삭제
    private Project project;

    @Builder
    public DevelopDiary(Long id, String title, String content,LocalDateTime createDate, Project project) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.project = project;
    }

    public DevelopDiary update(DevelopDiaryUpdateDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
        return this;
    }
}
