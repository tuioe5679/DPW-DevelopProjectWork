package com.tuioe.Develop.Project.Work.domain.developdiary;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DevelopDiaryRepository extends JpaRepository<DevelopDiary,Long> {

    List<DevelopDiary> findByProjectId(Long id);
}
