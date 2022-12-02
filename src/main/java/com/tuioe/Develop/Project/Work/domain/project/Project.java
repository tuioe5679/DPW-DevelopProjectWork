package com.tuioe.Develop.Project.Work.domain.project;

import com.tuioe.Develop.Project.Work.domain.tag.Tag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = false,length = 5000)
    private String content;

    @Column(length = 200)
    private String image;

    @Column(nullable = false,length = 20)
    private String startDate;

    @Column(nullable = false,length = 20)
    private String endDate;

    @Column(length = 100)
    private String giturl;

    @ManyToOne(fetch = FetchType.LAZY)// 지연 로딩 (빠른 속도 처리가능)
    @JoinColumn(name = "tag_id")
    private Tag tag;
}