package com.tuioe.Develop.Project.Work.service;

import com.tuioe.Develop.Project.Work.auth.CustomOAuth2UserService;
import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.domain.project.ProjectRepository;
import com.tuioe.Develop.Project.Work.domain.user.User;
import com.tuioe.Develop.Project.Work.domain.user.UserRepository;
import com.tuioe.Develop.Project.Work.dto.project.ProjectListResponseDto;
import com.tuioe.Develop.Project.Work.dto.project.ProjectRequestDto;
import com.tuioe.Develop.Project.Work.dto.project.ProjectResponseDto;
import com.tuioe.Develop.Project.Work.dto.project.ProjectUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    private final UserRepository userRepository;

    @Transactional
    public List<ProjectListResponseDto> findAllProject(){
        return projectRepository.findAll().stream()
                .map(ProjectListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProjectResponseDto findProject(Long id){
        Project project = projectRepository.findById(id).get();
        return new ProjectResponseDto().createProDto(project);
    }

    @Transactional
    public Project createProject(ProjectRequestDto dto){
        String email = CustomOAuth2UserService.sessionUser.getEmail();
        Optional<User> user = userRepository.findByEmail(email);
        return projectRepository.save(dto.toEntity(user.get()));
    }

    @Transactional
    public Project updateProject(Long id, ProjectUpdateDto dto){
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 없습니다"));
        return project.update(dto);
    }

    @Transactional
    public Long deleteProject(Long id){
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 프로젝트가 없습니다"));
        projectRepository.delete(project);
        return id;
    }
}
