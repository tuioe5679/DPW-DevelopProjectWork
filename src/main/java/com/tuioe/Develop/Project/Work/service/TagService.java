package com.tuioe.Develop.Project.Work.service;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.project.ProjectRepository;
import com.tuioe.Develop.Project.Work.domain.tag.Tag;
import com.tuioe.Develop.Project.Work.domain.tag.TagRepository;
import com.tuioe.Develop.Project.Work.dto.tag.TagListResponseDto;
import com.tuioe.Develop.Project.Work.dto.tag.TagRequestDto;
import com.tuioe.Develop.Project.Work.dto.tag.TagUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    private final ProjectRepository projectRepository;

    @Transactional
    public List<TagListResponseDto> findAllTag(){
        return tagRepository.findAll().stream()
                .map(TagListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Tag createTag(TagRequestDto dto){
        Project project = projectRepository.findById(dto.getId()).get();
        return tagRepository.save(dto.toEntity(project));
    }

    @Transactional
    public Tag updateTag(Long id, TagUpdateDto dto){
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 태그가 없습니다"));
        return tagRepository.save(tag.update(dto));
    }

    @Transactional
    public Long deleteTag(Long id){
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 태그가 없습니다"));
        tagRepository.delete(tag);
        return id;
    }

}
