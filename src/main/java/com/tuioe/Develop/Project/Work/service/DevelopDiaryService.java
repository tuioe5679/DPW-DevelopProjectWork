package com.tuioe.Develop.Project.Work.service;

import com.tuioe.Develop.Project.Work.domain.developdiary.DevelopDiary;
import com.tuioe.Develop.Project.Work.domain.developdiary.DevelopDiaryRepository;
import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.project.ProjectRepository;
import com.tuioe.Develop.Project.Work.domain.user.User;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryListResponseDto;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryRequestDto;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryResponseDto;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DevelopDiaryService {

    private final DevelopDiaryRepository developDiaryRepository;

    private final ProjectRepository projectRepository;

    // 개발일지 목록 조회
    @Transactional
    public List<DevelopDiaryListResponseDto> findAllDevelopDiary(Long id){
        return developDiaryRepository.findByProjectId(id).stream()
                .map(DevelopDiaryListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 개발일지 단건 조회
    @Transactional
    public DevelopDiaryResponseDto findDevelopDiary(Long id){
        DevelopDiary developDiary = developDiaryRepository.findById(id).get();
        return new DevelopDiaryResponseDto().createDiaryDto(developDiary);
    }

    // 개발일지 생성
    @Transactional
    public DevelopDiary createDevelopDiary(DevelopDiaryRequestDto dto){
        Project project = projectRepository.findById(dto.getId()).get();
        DevelopDiary developDiary = dto.toEntity(project);

        User user = project.getUser();
        user.jewelPlus(25);

        return developDiaryRepository.save(developDiary);
    }

    // 개발일지 수정
    @Transactional
    public DevelopDiary updateDevelopDiary(Long id, DevelopDiaryUpdateDto dto){
        DevelopDiary developDiary = developDiaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 개발일지는 없습니다"));
        return developDiary.update(dto);
    }

    // 개발일지 삭제
    @Transactional
    public Long deleteDevelopDiary(Long id){
        DevelopDiary developDiary = developDiaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 개발일지는 없습니다"));
        developDiaryRepository.delete(developDiary);
        return id;
    }

}
