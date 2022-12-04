package com.tuioe.Develop.Project.Work.domain.tag;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.dto.tag.TagUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 50)
    private String tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pro_id")
    private Project project;

    @Builder
    public Tag(Long id, String tag,Project project) {
        this.id = id;
        this.tag = tag;
        this.project = project;
    }

    public Tag update(TagUpdateDto dto){
        this.tag = dto.getTag();
        return this;
    }
}
