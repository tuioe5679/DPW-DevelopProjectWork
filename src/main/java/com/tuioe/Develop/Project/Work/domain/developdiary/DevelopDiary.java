package com.tuioe.Develop.Project.Work.domain.developdiary;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

    @Column(nullable = false)
    private LocalDateTime createDate;

    @ManyToOne(fetch = FetchType.LAZY)// 지연 로딩 (빠른 속도 처리가능)
    @JoinColumn(name = "pro_id")
    private Project project;
}
