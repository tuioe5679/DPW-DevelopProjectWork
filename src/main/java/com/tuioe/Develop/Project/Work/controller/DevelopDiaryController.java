package com.tuioe.Develop.Project.Work.controller;

import com.tuioe.Develop.Project.Work.domain.developdiary.DevelopDiary;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryRequestDto;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryResponseDto;
import com.tuioe.Develop.Project.Work.dto.developdiary.DevelopDiaryUpdateDto;
import com.tuioe.Develop.Project.Work.service.DevelopDiaryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Swagger API 명세서 페이지 -> http://localhost:8080/swagger-ui/index.html#/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Api(value = "DevelopDiary Controller",tags = "DevelopDiary")
public class DevelopDiaryController {

    private final DevelopDiaryService developDiaryService;


    @ApiOperation(value = "개발일지 목록 조회",notes = "개발일지를 전체 조회합니다")
    @GetMapping("/developdiarys/{id}")
    public ResponseEntity findAll(@PathVariable Long id){
        return new ResponseEntity<>(developDiaryService.findAllDevelopDiary(id), HttpStatus.OK);
    }

    @ApiOperation(value = "단건 개발일지 조회",notes = "개발일지를 단건 조회합니다")
    @GetMapping("/developdiary/{id}")
    public ResponseEntity<DevelopDiaryResponseDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(developDiaryService.findDevelopDiary(id), HttpStatus.OK);
    }

    @ApiOperation(value = "개발일지 생성",notes = "개발일지를 작성합니다")
    @PostMapping("/developdiary")
    public ResponseEntity<DevelopDiary> save(@RequestBody DevelopDiaryRequestDto dto){
        return new ResponseEntity<>(developDiaryService.createDevelopDiary(dto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "개발일지 수정",notes = "개발일지를 수정합니다")
    @PutMapping("/developdiary/{id}")
    public ResponseEntity<DevelopDiary> update(@PathVariable Long id, @RequestBody DevelopDiaryUpdateDto dto){
        return new ResponseEntity<>(developDiaryService.updateDevelopDiary(id,dto), HttpStatus.OK);
    }

    @ApiOperation(value = "개발일지 삭제",notes = "개발일지를 삭제합니다")
    @DeleteMapping("/developdiary/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        return new ResponseEntity(developDiaryService.deleteDevelopDiary(id), HttpStatus.OK);
    }
}
