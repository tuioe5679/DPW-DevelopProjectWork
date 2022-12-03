package com.tuioe.Develop.Project.Work.controller;

import com.tuioe.Develop.Project.Work.domain.project.Project;
import com.tuioe.Develop.Project.Work.dto.project.ProjectListResponseDto;
import com.tuioe.Develop.Project.Work.dto.project.ProjectRequestDto;
import com.tuioe.Develop.Project.Work.dto.project.ProjectResponseDto;
import com.tuioe.Develop.Project.Work.dto.project.ProjectUpdateDto;
import com.tuioe.Develop.Project.Work.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
@Api(value = "Project Controller",tags = "Project")
public class ProjectController {

    private final ProjectService projectService;

    @ApiOperation(value = "프로젝트 목록 조회",notes = "작성된 모든 프로젝트를 조회합니다")
    @GetMapping("/projects")
    public ResponseEntity<ProjectListResponseDto> findAll(){
        return new ResponseEntity(projectService.findAllProject(), HttpStatus.OK);
    }

    @ApiOperation(value = "단건 프로젝트 조회",notes = "프로젝트를 단건 조회합니다")
    @GetMapping("/project/{id}")
    public ResponseEntity<ProjectResponseDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(projectService.findProject(id),HttpStatus.OK);
    }

    @ApiOperation(value = "프로젝트 생성",notes = "프로젝트를 작성합니다")
    @PostMapping("/project")
    public ResponseEntity<Project> save(@RequestBody ProjectRequestDto dto){
        return new ResponseEntity<>(projectService.createProject(dto),HttpStatus.CREATED);
    }

    @ApiOperation(value = "프로젝트 수정",notes = "프로젝트를 수정합니다")
    @PutMapping("/project/{id}")
    public ResponseEntity<Project> update(@PathVariable Long id,@RequestBody ProjectUpdateDto dto){
        return new ResponseEntity<>(projectService.updateProject(id,dto),HttpStatus.OK);
    }

    @ApiOperation(value = "프로젝트 삭제",notes = "프로젝트를 삭제합니다")
    @DeleteMapping("/project/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return new ResponseEntity(projectService.deleteProject(id),HttpStatus.OK);
    }

}
