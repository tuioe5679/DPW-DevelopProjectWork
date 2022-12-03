package com.tuioe.Develop.Project.Work.service;

import com.tuioe.Develop.Project.Work.domain.developdiary.DevelopDiary;
import com.tuioe.Develop.Project.Work.domain.developdiary.DevelopDiaryRepository;
import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.project.ProjectRepository;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryRequestDto;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryResponseDto;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DevelopDiaryService {

    private final DevelopDiaryRepository developDiaryRepository;

    private final ProjectRepository projectRepository;

    @Transactional
    public DevelopDiaryResponseDto findDevelopDiary(Long id){
        DevelopDiary developDiary = developDiaryRepository.findById(id).get();
        return new DevelopDiaryResponseDto().createDiaryDto(developDiary);
    }

    @Transactional
    public DevelopDiary createDevelopDiary(DevelopDiaryRequestDto dto){
        Project project = projectRepository.findById(dto.getId()).get();
        DevelopDiary developDiary = dto.toEntity(project);
        return developDiaryRepository.save(developDiary);
    }

    @Transactional
    public DevelopDiary updateDevelopDiary(Long id, DevelopDiaryUpdateDto dto){
        DevelopDiary developDiary = developDiaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 개발일지는 없습니다"));
        return developDiary.update(dto);
    }

    @Transactional
    public Long deleteDevelopDiary(Long id){
        DevelopDiary developDiary = developDiaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 개발일지는 없습니다"));
        developDiaryRepository.delete(developDiary);
        return id;
    }

}
